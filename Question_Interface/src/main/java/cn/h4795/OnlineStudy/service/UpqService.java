package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Upq;
// import cn.h4795.pojo.Upq;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UpqService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Upq> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Upq upq);
	
	
	/**
	 * 修改
	 */
	public void update(Upq upq);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Upq findOne(Integer id);
	
	
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
	public PageResult findPage(Upq upq, int pageNum, int pageSize);

	/**
	 * 添加upq列表
	 * @param upqList
	 */
	public void addList(List upqList);
	
}
