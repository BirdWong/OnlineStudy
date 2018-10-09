package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Category;
// import cn.h4795.pojo.Category;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface CategoryService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Category> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Category category);
	
	
	/**
	 * 修改
	 */
	public void update(Category category);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Category findOne(Integer id);
	
	
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
	public PageResult findPage(Category category, int pageNum, int pageSize);


	/**
	 * 通过课程id查找目录列表
	 * @param id
	 * @return
	 */
	public List<Category> findByParentId(Integer id);

	/**
	 * 通过删除课程来删除category
	 * @param id
	 */
	public void deleteByParentId(Integer id);
}
