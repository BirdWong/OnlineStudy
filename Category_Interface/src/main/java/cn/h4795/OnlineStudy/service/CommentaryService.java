package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Commentary;
// import cn.h4795.pojo.Commentary;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface CommentaryService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Commentary> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Commentary commentary);
	
	
	/**
	 * 修改
	 */
	public void update(Commentary commentary);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Commentary findOne(Integer id);
	
	
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
	public PageResult findPage(Commentary commentary, int pageNum, int pageSize);


	/**
	 * 根据课程查找评论
	 * @param id
	 * @return
	 */
	public List<Commentary> findByCourseId(Integer id);


	/**
	 * 通过课程id删除评论
	 * @param id
	 */
	public void deleteByParentId(Integer id);
}
