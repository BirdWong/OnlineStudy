package cn.h4795.OnlineStudy.service.impl;
import java.util.ArrayList;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.CourseMapper;
import cn.h4795.OnlineStudy.Mapper.PersonalMapper;
import cn.h4795.OnlineStudy.Pojo.*;
import cn.h4795.OnlineStudy.service.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.h4795.OnlineStudy.Pojo.CourseExample.Criteria;

import entity.PageResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;


	@Autowired
	private RedisTemplate redisTemplate;

//	@Reference
//	private CourseSearchService courseSearchService;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination queueSolrDestination;

	@Autowired
	private Destination queueSolrDeleteDestination;

	@Autowired
	private KindService kindService;

	@Autowired
	private PersonalMapper personalMapper;

	@Autowired
	private CategoryService categoryService;




	/**
	 * 查询全部
	 */
	@Override
	public List< Course> findAll() {
		return courseMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Course> page=   (Page< Course>) courseMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Course course) {

        try{
            System.out.println(course.getCname());
            System.out.println(course.getCdescription());
            //向数据库中插入这条记录
			courseMapper.insert(course);
			//清除缓存
            if (redisTemplate.hasKey("course")){
                if (redisTemplate.boundHashOps("course").hasKey(course.getKid())){
                    redisTemplate.boundHashOps("course").delete(course.getKid());

                }
            }


			CourseSolr courseSolr = getCourseSolr(course);

//			courseSearchService.importCourseSolr(courseSolr);
			List<CourseSolr> courseSolrList = new ArrayList<>();
			courseSolrList.add(courseSolr);
			String jsonString = JSON.toJSONString(courseSolrList);
            System.out.println(jsonString);
            jmsTemplate.send(queueSolrDestination, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(jsonString);
				}
			});
		}catch (Exception e){
            e.printStackTrace();
		}

	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Course course){


		try {
			//得到course之前所属的kindid
			Course course1 = courseMapper.selectByPrimaryKey(course.getId());
			if (course1 != null){
				Integer kid = course1.getKid();

				courseMapper.updateByPrimaryKey(course);
				if (redisTemplate.hasKey("course")&&
						redisTemplate.boundHashOps("course").hasKey(kid)){
					//1、清除目前所在的分类缓存
					redisTemplate.boundHashOps("course").delete(kid);
				}

				//判断更改的是否是kindid
				if(kid.intValue() != course.getKid().intValue()&&
						redisTemplate.hasKey("course")&&
						redisTemplate.boundHashOps("course").hasKey(course.getKid())){
					//2、清除更新后所在组的缓存
					redisTemplate.boundHashOps("course").delete(course.getKid());

				}
				//删除原来的记录-solr
				//courseSearchService.deleteByCourseId(course.getId()+0L);
				jmsTemplate.send(queueSolrDeleteDestination, new MessageCreator() {
					@Override
					public Message createMessage(Session session) throws JMSException {
						Long courseId = course.getId() + 0L;
						return session.createObjectMessage(courseId);
					}
				});
				//添加修改后的记录-solr
				//courseSearchService.importCourseSolr(getCourseSolr(course));
				jmsTemplate.send(queueSolrDestination, new MessageCreator() {
					@Override
					public Message createMessage(Session session) throws JMSException {
						List<CourseSolr> list = new ArrayList<>();
						list.add(getCourseSolr(course));
						String text = JSON.toJSONString(list);
						return session.createTextMessage(text);
					}
				});
			}

		}catch (Exception e){

		}



	}
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Course findOne(Integer id){
		return courseMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) throws Exception {

		for (Integer integer : ids){
			System.out.println(integer);
		}
		for(Integer id:ids){
			//在没有删除之前先查找到这个course
			Course course = courseMapper.selectByPrimaryKey(id);

			Integer kid = null;
			if (course != null){
				kid = course.getKid();
				try{
					//删除这个course
					courseMapper.deleteByPrimaryKey(id);


					//通过之前查找好的kid 清除缓存
					if (kid != null && redisTemplate.hasKey("course")&&
							redisTemplate.boundHashOps("course").hasKey(kid)){
						redisTemplate.boundHashOps("course").delete(kid);

					}


					jmsTemplate.send(queueSolrDeleteDestination, new MessageCreator() {
						@Override
						public Message createMessage(Session session) throws JMSException {
							Long courseId = id  + 0L;
							return session.createObjectMessage(courseId);
						}
					});
				}catch (Exception e){
					e.printStackTrace();
				}
			}else {
				throw  new Exception();
			}





		}
	}
	
	
		@Override
	public PageResult findPage( Course course, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 CourseExample example=new  CourseExample();
		Criteria criteria = example.createCriteria();
		
		if(course!=null){			
			if(course.getCname()!=null && course.getCname().length()>0){
				criteria.andCnameLike("%"+course.getCname()+"%");
			}
			if(course.getCurl()!=null && course.getCurl().length()>0){
				criteria.andCurlLike("%"+course.getCurl()+"%");
			}
			if(course.getCdescription()!=null && course.getCdescription().length()>0){
				criteria.andCdescriptionLike("%"+course.getCdescription()+"%");
			}
	
		}
		
		Page< Course> page= (Page< Course>)courseMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}





	/**
	 * 通过kindId查找到这个kind所属的所有课程
	 * @param kindId
	 * @return
	 */

	@Override
	public PageResult findByKindId(Integer kindId,int pageNum,int pageSize){


		PageHelper.startPage(pageNum,pageSize);

		Page<Course> page = null;

		CourseExample example = new CourseExample();

		Criteria criteria = example.createCriteria();

		criteria.andKidEqualTo(kindId);

		example.setOrderByClause("id");

		page = (Page<Course>) courseMapper.selectByExample(example);


		return  new PageResult(page.getTotal(),page.getResult());

	}

	@Override
	public void deleteByParentId(Integer id) {
		CourseExample example = new CourseExample();

		Criteria criteria = example.createCriteria();

		criteria.andKidEqualTo(id);

		List<Course> courseList = courseMapper.selectByExample(example);

		for (Course course:courseList){

			categoryService.deleteByParentId(course.getId());

			courseMapper.deleteByPrimaryKey(course.getId());
		}
	}

	/**
	 * 通过course生成CourseSolr
	 * @param course
	 * @return
	 */
	private CourseSolr getCourseSolr(Course course){
		//在数据库中找到这个course获取Id
		CourseExample example = new CourseExample();
		Criteria criteria = example.createCriteria();
		criteria.andKidEqualTo(course.getKid());
		criteria.andCdescriptionEqualTo(course.getCdescription());
		criteria.andCnameEqualTo(course.getCname());
		criteria.andCurlEqualTo(course.getCurl());
		criteria.andUidEqualTo(course.getUid());
		List<Course> courses = courseMapper.selectByExample(example);
		course = courses.get(0);

		//通过kid查找到kind的name
		Kind kind = kindService.findOne(course.getKid());

		//通过uid查找到user的name
		PersonalExample personalExample = new PersonalExample();
		PersonalExample.Criteria persionalCriteria = personalExample.createCriteria();
		persionalCriteria.andUidEqualTo(course.getUid());
		List<Personal> personals = personalMapper.selectByExample(personalExample);
		Personal personal = personals.get(0);

		//将course还有kname，username赋给CourseSolr
		CourseSolr solr = new CourseSolr();
		solr.setId(course.getId()+0L);
		solr.setCname(course.getCname());
		solr.setCdescription(course.getCdescription());
		solr.setCurl(course.getCurl());
		solr.setKind(kind.getKname());
		solr.setUser(personal.getPname());
		return solr;
	}


}
