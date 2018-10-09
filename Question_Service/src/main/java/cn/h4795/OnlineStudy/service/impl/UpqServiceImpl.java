package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.UpqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. UpqMapper;
// import cn.h4795.pojo. Upq;

// import com.pinyougou.pojo. UpqExample;
import cn.h4795.OnlineStudy.Pojo.Upq;
import cn.h4795.OnlineStudy.Pojo.UpqExample;
import cn.h4795.OnlineStudy.Pojo.UpqExample.Criteria;
// import com.pinyougou.pojo. UpqExample.Criteria;
import cn.h4795.OnlineStudy.service.UpqService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class UpqServiceImpl implements UpqService {

	@Autowired
	private UpqMapper upqMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Upq> findAll() {
		return upqMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Upq> page=   (Page< Upq>) upqMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Upq upq) {
		upqMapper.insert(upq);		
	}


	@Override
	public void addList(List upqList){
		for (Object object: upqList){

			Upq upq = (Upq)object;

			add(upq);

		}
	}
	
	/**
	 * 修改
	 */
	@Override
	public void update( Upq upq){
		upqMapper.updateByPrimaryKey(upq);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Upq findOne(Integer id){
		return upqMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			upqMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Upq upq, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 UpqExample example=new  UpqExample();
		Criteria criteria = example.createCriteria();
		
		if(upq!=null){			
				
		}
		
		Page< Upq> page= (Page< Upq>)upqMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
