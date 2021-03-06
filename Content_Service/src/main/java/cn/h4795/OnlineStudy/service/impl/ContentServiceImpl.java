package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. ContentMapper;
// import cn.h4795.pojo. Content;

// import com.pinyougou.pojo. ContentExample;
import cn.h4795.OnlineStudy.Pojo.Content;
import cn.h4795.OnlineStudy.Pojo.ContentExample;
import cn.h4795.OnlineStudy.Pojo.ContentExample.Criteria;
// import com.pinyougou.pojo. ContentExample.Criteria;
import cn.h4795.OnlineStudy.service.ContentService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Content> findAll() {
		return contentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Content> page=   (Page< Content>) contentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Content content) {
		contentMapper.insert(content);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Content content){
		contentMapper.updateByPrimaryKey(content);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Content findOne(Integer id){
		return contentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			contentMapper.deleteByPrimaryKey(id);
		}		
	}
	



	@Override
	public PageResult findPage( Content content, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 ContentExample example=new  ContentExample();
		Criteria criteria = example.createCriteria();
		
		if(content!=null){			
			if(content.getUrl()!=null && content.getUrl().length()>0){
				criteria.andUrlLike("%"+content.getUrl()+"%");
			}
	
		}
		
		Page< Content> page= (Page< Content>)contentMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
