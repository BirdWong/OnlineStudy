package cn.h4795.OnlineStudy.service.impl;
import java.util.*;

import cn.h4795.OnlineStudy.Mapper.QuestionMapper;
import cn.h4795.OnlineStudy.Pojo.Choice;
import cn.h4795.OnlineStudy.Pojo.Problem;
import cn.h4795.OnlineStudy.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. QuestionMapper;
// import cn.h4795.pojo. Question;

// import com.pinyougou.pojo. QuestionExample;
import cn.h4795.OnlineStudy.Pojo.Question;
import cn.h4795.OnlineStudy.Pojo.QuestionExample;
import cn.h4795.OnlineStudy.Pojo.QuestionExample.Criteria;
// import com.pinyougou.pojo. QuestionExample.Criteria;
import cn.h4795.OnlineStudy.service.QuestionService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper questionMapper;

	@Autowired
	private ChoiceService choiceService;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Question> findAll() {
		return questionMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Question> page=   (Page< Question>) questionMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Question question) {

		questionMapper.insert(question);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Question question){
		questionMapper.updateByPrimaryKey(question);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Question findOne(Integer id){
		return questionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			questionMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Question question, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 QuestionExample example=new  QuestionExample();
		Criteria criteria = example.createCriteria();
		
		if(question!=null){			
						if(question.getPurl()!=null && question.getPurl().length()>0){
				criteria.andPurlLike("%"+question.getPurl()+"%");
			}
			if(question.getAswer()!=null && question.getAswer().length()>0){
				criteria.andAswerLike("%"+question.getAswer()+"%");
			}
			if(question.getDescription()!=null && question.getDescription().length()>0){
				criteria.andDescriptionLike("%"+question.getDescription()+"%");
			}
	
		}
		
		Page< Question> page= (Page< Question>)questionMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
