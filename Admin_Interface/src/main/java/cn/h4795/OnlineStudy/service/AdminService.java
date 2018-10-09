package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Admin;
// import cn.h4795.pojo.Admin;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AdminService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Admin> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Admin admin);
	
	
	/**
	 * 修改
	 */
	public void update(Admin admin);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Admin findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Admin admin, int pageNum, int pageSize);
	
}
