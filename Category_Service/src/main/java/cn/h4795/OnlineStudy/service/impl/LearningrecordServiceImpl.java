package cn.h4795.OnlineStudy.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.h4795.OnlineStudy.Mapper.CourseMapper;
import cn.h4795.OnlineStudy.Mapper.KindMapper;
import cn.h4795.OnlineStudy.Mapper.LearningrecordMapper;
import cn.h4795.OnlineStudy.Mapper.UserMapper;
import cn.h4795.OnlineStudy.Pojo.*;
import cn.h4795.OnlineStudy.service.LearningrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.h4795.OnlineStudy.Pojo.LearningrecordExample.Criteria;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class LearningrecordServiceImpl implements LearningrecordService {

	@Autowired
	private LearningrecordMapper learningrecordMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private KindMapper kindMapper;

	@Autowired
	private CourseMapper courseMapper ;



	/**
	 * 查询全部
	 */
	@Override
	public List< Learningrecord> findAll() {
		return learningrecordMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Learningrecord> page=   (Page< Learningrecord>) learningrecordMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Learningrecord learningrecord) {
		learningrecordMapper.insert(learningrecord);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Learningrecord learningrecord){
		learningrecordMapper.updateByPrimaryKey(learningrecord);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Learningrecord findOne(Integer id){
		return learningrecordMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			learningrecordMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Learningrecord learningrecord, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 LearningrecordExample example=new  LearningrecordExample();
		Criteria criteria = example.createCriteria();
		
		if(learningrecord!=null){			
				
		}
		
		Page< Learningrecord> page= (Page< Learningrecord>)learningrecordMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 通过course的id 查找学习了这个课程的用户
	 * @param id
	 * @return
	 */
	@Override
	public PageResult findByCourseId(Integer id,int pageNum, int pageSize){

		PageHelper.startPage(pageNum,pageSize);
		LearningrecordExample example = new LearningrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andCidEqualTo(id);

		List<Learningrecord> learningrecords = learningrecordMapper.selectByExample(example);

		List<User> list = new ArrayList<>();

		for (Learningrecord learningrecord : learningrecords){
			User user = userMapper.selectByPrimaryKey(learningrecord.getUid());
			list.add(user);
		}
		Page<User> page = (Page<User>) list;
		return new PageResult(page.getTotal(),page.getResult());
	}

	/**
	 * 通过查询课程id 得到学习该课程的人数
	 * @param id
	 * @return
	 */
	@Override
	public Integer countByCourseId(Integer id){
		LearningrecordExample example = new LearningrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andCidEqualTo(id);

		Integer learningrecords = learningrecordMapper.countByExample(example);

		return learningrecords;
	}

	/**
	 * 通过user的id查询这个用户学习过的course记录
	 * @param id
	 * @return
	 */
	@Override
	public PageResult findCourseByUserId(Integer id,int pageNum, int pageSize){

		PageHelper.startPage(pageNum,pageSize);

		LearningrecordExample example = new LearningrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andUidEqualTo(id);

		List<Learningrecord> learningrecords = learningrecordMapper.selectByExample(example);

		List<Course> courseList = new ArrayList<>();

		for (Learningrecord learningrecord : learningrecords){

			Course course = courseMapper.selectByPrimaryKey(learningrecord.getCid());

			courseList.add(course);
		}

		Page<Course> page = (Page<Course>) courseList;
		return new PageResult(page.getTotal(),page.getResult());
	}


	/**
	 * 通过user的id查询这个用户学习方向kind
	 * @param id
	 * @return
	 */
	@Override
	public PageResult findKindByUserId(Integer id,int pageNum, int pageSize){

		PageHelper.startPage(pageNum,pageSize);

		LearningrecordExample example = new LearningrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andUidEqualTo(id);

		List<Learningrecord> learningrecords = learningrecordMapper.selectByExample(example);

		List<Kind> kindList = new ArrayList<>();

		for (Learningrecord learningrecord : learningrecords){

			Kind kind = kindMapper.selectByPrimaryKey(learningrecord.getKid());

			kindList.add(kind);
		}

		Page<Kind> page = (Page<Kind>) kindList;
		return new PageResult(page.getTotal(),page.getResult());
	}


	/**
	 * 通过user的id，得到学习的课程数量
	 * @param id
	 * @return
	 */
	@Override
	public Integer countByUserId(Integer id){
		LearningrecordExample example = new LearningrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andUidEqualTo(id);

		Integer count = learningrecordMapper.countByExample(example);

		return count;
	}

	@Override
	public void deleteByUserId(Integer id) {
		LearningrecordExample example = new LearningrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andUidEqualTo(id);

		learningrecordMapper.deleteByExample(example);
	}

	@Override
	public void deleteByCourseId(Integer id) {

		LearningrecordExample example = new LearningrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andCidEqualTo(id);

		learningrecordMapper.deleteByExample(example);
	}

}
