package cn.h4795.OnlineStudy.service.impl;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
// import cn.h4795.mapper. MessageMapper;
// import cn.h4795.pojo. Message;

// import com.pinyougou.pojo. MessageExample;
import cn.h4795.OnlineStudy.Pojo.Message;
import cn.h4795.OnlineStudy.Pojo.MessageExample;
import cn.h4795.OnlineStudy.Pojo.MessageExample.Criteria;
// import com.pinyougou.pojo. MessageExample.Criteria;
import cn.h4795.OnlineStudy.service.MessageService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List< Message> findAll() {
		return messageMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< Message> page=   (Page< Message>) messageMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add( Message message) {
		messageMapper.insert(message);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( Message message){
		messageMapper.updateByPrimaryKey(message);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  Message findOne(Integer id){
		return messageMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			messageMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( Message message, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 MessageExample example=new  MessageExample();
		Criteria criteria = example.createCriteria();
		
		if(message!=null){			
						if(message.getMtext()!=null && message.getMtext().length()>0){
				criteria.andMtextLike("%"+message.getMtext()+"%");
			}
	
		}
		
		Page< Message> page= (Page< Message>)messageMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
