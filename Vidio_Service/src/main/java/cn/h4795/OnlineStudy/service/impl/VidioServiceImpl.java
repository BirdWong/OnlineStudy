package cn.h4795.OnlineStudy.service.impl;
import java.util.Date;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.*;
import cn.h4795.OnlineStudy.Pojo.*;
import cn.h4795.OnlineStudy.service.BarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. VidioMapper;
// import cn.h4795.pojo. Vidio;

// import com.pinyougou.pojo. VidioExample;
import cn.h4795.OnlineStudy.Pojo.VidioExample.Criteria;
// import com.pinyougou.pojo. VidioExample.Criteria;
import cn.h4795.OnlineStudy.service.VidioService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class VidioServiceImpl implements VidioService {

	@Autowired
	private VidioMapper vidioMapper;

	@Autowired
	private BarrageService barrageService;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CategoryMapper categoryMapper ;

	@Autowired
	private CourseMapper courseMapper ;

	@Autowired
	private LearningrecordMapper learningrecordMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Vidio> findAll() {
		return vidioMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Vidio> page=   (Page< Vidio>) vidioMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Vidio vidio) {
		vidioMapper.insert(vidio);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Vidio vidio){
		vidioMapper.updateByPrimaryKey(vidio);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Vidio findOne(Integer id){


		return vidioMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			vidioMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Vidio vidio, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 VidioExample example=new  VidioExample();
		Criteria criteria = example.createCriteria();
		
		if(vidio!=null){			
						if(vidio.getVname()!=null && vidio.getVname().length()>0){
				criteria.andVnameLike("%"+vidio.getVname()+"%");
			}
			if(vidio.getVtext()!=null && vidio.getVtext().length()>0){
				criteria.andVtextLike("%"+vidio.getVtext()+"%");
			}
			if(vidio.getVurl()!=null && vidio.getVurl().length()>0){
				criteria.andVurlLike("%"+vidio.getVurl()+"%");
			}
	
		}
		
		Page< Vidio> page= (Page< Vidio>)vidioMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void deleteByCategoryId(Integer id) {

		VidioExample example = new VidioExample();

		Criteria criteria = example.createCriteria();

		criteria.andCidEqualTo(id);

		List<Vidio> vidios = vidioMapper.selectByExample(example);

		Vidio vidio = vidios.get(0);

		barrageService.deleteByParentId(vidio.getId());

		vidioMapper.deleteByPrimaryKey(vidio.getId());

	}


	/**
	 * 通过categoryid获取vidio
	 * @param cid
	 * @param uid
	 * @return
	 */
	@Override
	public Vidio findByCategoryId(Integer cid,Integer uid) {
		VidioExample example = new VidioExample();

		Criteria criteria =  example.createCriteria();

		criteria.andCidEqualTo(cid);

		List<Vidio> vidios = vidioMapper.selectByExample(example);

		if (vidios == null || vidios.size() == 0  ){
			return  null;
		}
		Vidio vidio = vidios.get(0);


		User user= userMapper.selectByPrimaryKey(uid);

		Category category = categoryMapper.selectByPrimaryKey(vidio.getCid());

		Course course = courseMapper.selectByPrimaryKey(category.getCid());

		Learningrecord learningrecord = new Learningrecord();

		learningrecord.setCid(course.getId());

		learningrecord.setKid(course.getKid());

		learningrecord.setUid(user.getId());

		learningrecord.setStudytime(new Date());

		learningrecordMapper.insert(learningrecord);

		return vidio;

	}



}
