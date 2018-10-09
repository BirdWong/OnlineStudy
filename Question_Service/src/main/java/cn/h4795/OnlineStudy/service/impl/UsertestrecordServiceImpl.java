package cn.h4795.OnlineStudy.service.impl;
import java.util.*;

import cn.h4795.OnlineStudy.Mapper.*;
import cn.h4795.OnlineStudy.Pojo.*;
import com.alibaba.dubbo.container.page.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.h4795.OnlineStudy.Pojo.UsertestrecordExample.Criteria;

import cn.h4795.OnlineStudy.service.UsertestrecordService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class UsertestrecordServiceImpl implements UsertestrecordService {

	@Autowired
	private UsertestrecordMapper usertestrecordMapper;


	@Autowired
	private PaperMapper paperMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UpqMapper upqMapper;

	@Autowired
	private QuestionMapper questionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Usertestrecord> findAll() {
		return usertestrecordMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Usertestrecord> page=   (Page< Usertestrecord>) usertestrecordMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Usertestrecord usertestrecord) {
		usertestrecordMapper.insert(usertestrecord);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Usertestrecord usertestrecord){
		usertestrecordMapper.updateByPrimaryKey(usertestrecord);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Usertestrecord findOne(Integer id){
		return usertestrecordMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			usertestrecordMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage( Usertestrecord usertestrecord, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 UsertestrecordExample example=new  UsertestrecordExample();
		Criteria criteria = example.createCriteria();
		
		if(usertestrecord!=null){			
				
		}
		
		Page< Usertestrecord> page= (Page< Usertestrecord>)usertestrecordMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 通过User的id查询user的刷题题组
	 * @param id
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageResult findByUserId(Integer id, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);

		UsertestrecordExample usertestrecordExample = new UsertestrecordExample();

		Criteria criteria = usertestrecordExample.createCriteria();

		criteria.andUidEqualTo(id);

		List<Usertestrecord> usertestrecords = usertestrecordMapper.selectByExample(usertestrecordExample);

		List<Paper> paperList = new ArrayList<>();
		for (Usertestrecord usertestrecord : usertestrecords){
			Paper paper = paperMapper.selectByPrimaryKey(usertestrecord.getPid());
			paperList.add(paper);
		}

		Page<Paper> paperPage = (Page<Paper>)paperList;

		return new PageResult(paperPage.getTotal(),paperPage.getResult());
	}

	/**
	 * t通过paper的id分页查询刷题的user人数
	 * @param id
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageResult findByPaperId(Integer id, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);

		UsertestrecordExample example = new UsertestrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andPidEqualTo(id);

		List<Usertestrecord> usertestrecords = usertestrecordMapper.selectByExample(example);

		List<User> userList = new ArrayList<>();

		for (Usertestrecord usertestrecord : usertestrecords){

			User user = userMapper.selectByPrimaryKey(usertestrecord.getUid());

			userList.add(user);
		}
		Page<User> userPage = (Page<User>) userList;

		return new PageResult(userPage.getTotal(),userPage.getResult());
	}


	/**
	 * 通过user的id查询这个用户做过多少题组
	 * @param id
	 * @return
	 */
	@Override
	public Integer countByUser(Integer id) {


		UsertestrecordExample example = new UsertestrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andUidEqualTo(id);

		Integer count = usertestrecordMapper.countByExample(example);

		return count;
	}


	/**
	 * 通过paper的id查询这个题组刷过多少题
	 * @param id
	 * @return
	 */
	@Override
	public Integer countByPaper(Integer id) {

		UsertestrecordExample example = new UsertestrecordExample();

		Criteria criteria = example.createCriteria();

		criteria.andPidEqualTo(id);

		int count = usertestrecordMapper.countByExample(example);
		return count;
	}




	/**
	 * 上传用户成绩
	 * @param uid
	 * @param pid
	 * @param score
	 */
	@Override
	public void submit(Integer uid, Integer pid,Integer score) {




		UsertestrecordExample usertestrecordExample = new UsertestrecordExample();

		UsertestrecordExample.Criteria usertestrecordExampleCriteria = usertestrecordExample.createCriteria();

		usertestrecordExampleCriteria.andPidEqualTo(pid);

		usertestrecordExampleCriteria.andUidEqualTo(uid);

		List<Usertestrecord> usertestrecords = usertestrecordMapper.selectByExample(usertestrecordExample);
		if (usertestrecords.size() == 0){
			Usertestrecord usertestrecord = new Usertestrecord();

			usertestrecord.setPid(pid);

			usertestrecord.setUid(uid);

			usertestrecord.setTesttime(new Date());

			usertestrecordMapper.insert(usertestrecord);
		}else {
			Usertestrecord usertestrecord = usertestrecords.get(0);

			usertestrecord.setScore(score);

			usertestrecordMapper.updateByPrimaryKey(usertestrecord);
		}



	}

	@Override
	public Map TestOne(Integer uid, Integer pid) {

		//1.拿到用户的刷题记录
		UsertestrecordExample usertestrecordExample = new UsertestrecordExample();

		Criteria criteria = usertestrecordExample.createCriteria();

		criteria.andUidEqualTo(uid);

		criteria.andPidEqualTo(pid);

		List<Usertestrecord> usertestrecordList = usertestrecordMapper.selectByExample(usertestrecordExample);

		//2.拿到数据
		List<GG> ggList = getKindSum(usertestrecordList);

		Map map = new HashMap();
		map.put("score",usertestrecordList.get(0).getScore());

		map.put("kind",ggList);
		return  map;
	}


	/**
	 * 统计用户每个方向的题目刷过多少个
	 * @param uid
	 * @return
	 */
	@Override
	public List<GG> studyPath(Integer uid) {

		//1.拿到用户的刷题记录
		UsertestrecordExample usertestrecordExample = new UsertestrecordExample();

		Criteria criteria = usertestrecordExample.createCriteria();

		criteria.andUidEqualTo(uid);

		List<Usertestrecord> usertestrecordList = usertestrecordMapper.selectByExample(usertestrecordExample);

		//2.拿到数据
		List<GG> ggList = getKindSum(usertestrecordList);

		return  ggList;


	}


	private List<GG> getKindSum(List<Usertestrecord> usertestrecordList){
		//1.通过每次刷题记录，拿到该题组id，将刷过的题目id存入set
		Set<Integer> qidSet = new HashSet<>();

		for (Usertestrecord usertestrecord : usertestrecordList){

			UpqExample upqExample = new UpqExample();

			UpqExample.Criteria upqExampleCriteria = upqExample.createCriteria();

			upqExampleCriteria.andPidEqualTo(usertestrecord.getPid());

			List<Upq> upqList = upqMapper.selectByExample(upqExample);

			for (Upq upq : upqList){
				qidSet.add(upq.getQid());
			}


		}



		//3.通过set中的id查询分类

		Map<Integer,Integer> map = new HashMap();

		for (Integer qid : qidSet){

			Question question = questionMapper.selectByPrimaryKey(qid);

			if (map.containsKey(question.getKid())){
				Integer sum = map.get(question.getKid());

				sum = sum + 1;

				map.remove(question.getKid());

				map.put(question.getKid(),sum);
			}else {
				map.put(question.getKid(),1);

			}

		}


		List<GG> ggList = new ArrayList<>();

		for (Integer id : map.keySet()){

			GG gg = new GG();

			gg.setKid(id);
			gg.setCount(map.get(id));

			ggList.add(gg);
		}

		return  ggList;
	}






}
