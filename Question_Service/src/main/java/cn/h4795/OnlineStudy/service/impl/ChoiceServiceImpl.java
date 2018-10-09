package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.ChoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.h4795.OnlineStudy.Pojo.Choice;
import cn.h4795.OnlineStudy.Pojo.ChoiceExample;
import cn.h4795.OnlineStudy.Pojo.ChoiceExample.Criteria;

import cn.h4795.OnlineStudy.service.ChoiceService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class ChoiceServiceImpl implements ChoiceService {

	@Autowired
	private ChoiceMapper choiceMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Choice> findAll() {
		return choiceMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Choice> page=   (Page< Choice>) choiceMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Choice choice) {
		choiceMapper.insert(choice);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Choice choice){
		choiceMapper.updateByPrimaryKey(choice);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Choice findOne(Integer id){
		return choiceMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			choiceMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Choice choice, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 ChoiceExample example=new  ChoiceExample();
		Criteria criteria = example.createCriteria();
		
		if(choice!=null){			
						if(choice.getDescription()!=null && choice.getDescription().length()>0){
				criteria.andDescriptionLike("%"+choice.getDescription()+"%");
			}
	
		}
		
		Page< Choice> page= (Page< Choice>)choiceMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
