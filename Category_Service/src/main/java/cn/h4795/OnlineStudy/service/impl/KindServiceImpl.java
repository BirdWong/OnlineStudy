package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.KindMapper;
import cn.h4795.OnlineStudy.Pojo.Course;
import cn.h4795.OnlineStudy.Pojo.CourseExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. KindMapper;
// import cn.h4795.pojo. Kind;

// import com.pinyougou.pojo. KindExample;
import cn.h4795.OnlineStudy.Pojo.Kind;
import cn.h4795.OnlineStudy.Pojo.KindExample;
import cn.h4795.OnlineStudy.Pojo.KindExample.Criteria;
// import com.pinyougou.pojo. KindExample.Criteria;
import cn.h4795.OnlineStudy.service.KindService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class KindServiceImpl implements KindService {

	@Autowired
	private KindMapper kindMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Kind> findAll() {
		return kindMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Kind> page=   (Page< Kind>) kindMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Kind kind) {
		kindMapper.insert(kind);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Kind kind){
		kindMapper.updateByPrimaryKey(kind);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Kind findOne(Integer id){
		return kindMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			kindMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Kind kind, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 KindExample example=new  KindExample();
		Criteria criteria = example.createCriteria();
		
		if(kind!=null){			
						if(kind.getKname()!=null && kind.getKname().length()>0){
				criteria.andKnameLike("%"+kind.getKname()+"%");
			}
			if(kind.getKdescription()!=null && kind.getKdescription().length()>0){
				criteria.andKdescriptionLike("%"+kind.getKdescription()+"%");
			}
	
		}
		
		Page< Kind> page= (Page< Kind>)kindMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}




	
}
