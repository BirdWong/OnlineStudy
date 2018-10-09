package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Message;
// import cn.h4795.pojo.Message;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface MessageService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Message> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Message message);
	
	
	/**
	 * 修改
	 */
	public void update(Message message);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Message findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Message message, int pageNum, int pageSize);
	
}
