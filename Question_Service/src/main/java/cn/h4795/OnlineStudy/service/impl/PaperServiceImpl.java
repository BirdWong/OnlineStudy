package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. PaperMapper;
// import cn.h4795.pojo. Paper;

// import com.pinyougou.pojo. PaperExample;
import cn.h4795.OnlineStudy.Pojo.Paper;
import cn.h4795.OnlineStudy.Pojo.PaperExample;
import cn.h4795.OnlineStudy.Pojo.PaperExample.Criteria;
// import com.pinyougou.pojo. PaperExample.Criteria;
import cn.h4795.OnlineStudy.service.PaperService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class PaperServiceImpl implements PaperService {

	@Autowired
	private PaperMapper paperMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Paper> findAll() {
		return paperMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Paper> page=   (Page< Paper>) paperMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Paper paper) {
		paperMapper.insert(paper);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Paper paper){
		paperMapper.updateByPrimaryKey(paper);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Paper findOne(Integer id){
		return paperMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			paperMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Paper paper, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 PaperExample example=new  PaperExample();
		Criteria criteria = example.createCriteria();
		
		if(paper!=null){			
						if(paper.getName()!=null && paper.getName().length()>0){
				criteria.andNameLike("%"+paper.getName()+"%");
			}
	
		}
		
		Page< Paper> page= (Page< Paper>)paperMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
