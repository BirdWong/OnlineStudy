package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.BarrageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. BarrageMapper;
// import cn.h4795.pojo. Barrage;

// import com.pinyougou.pojo. BarrageExample;
import cn.h4795.OnlineStudy.Pojo.Barrage;
import cn.h4795.OnlineStudy.Pojo.BarrageExample;
import cn.h4795.OnlineStudy.Pojo.BarrageExample.Criteria;
// import com.pinyougou.pojo. BarrageExample.Criteria;
import cn.h4795.OnlineStudy.service.BarrageService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class BarrageServiceImpl implements BarrageService {

	@Autowired
	private BarrageMapper barrageMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Barrage> findAll() {
		return barrageMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Barrage> page=   (Page< Barrage>) barrageMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Barrage barrage) {
		barrageMapper.insert(barrage);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Barrage barrage){
		barrageMapper.updateByPrimaryKey(barrage);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Barrage findOne(Integer id){
		return barrageMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			barrageMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Barrage barrage, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 BarrageExample example=new  BarrageExample();
		Criteria criteria = example.createCriteria();
		
		if(barrage!=null){			
						if(barrage.getBtext()!=null && barrage.getBtext().length()>0){
				criteria.andBtextLike("%"+barrage.getBtext()+"%");
			}
	
		}
		
		Page< Barrage> page= (Page< Barrage>)barrageMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void deleteByParentId(Integer id) {
		BarrageExample example = new BarrageExample();

		Criteria criteria = example.createCriteria();

		criteria.andVidEqualTo(id);

		barrageMapper.deleteByExample(example);
	}

}
