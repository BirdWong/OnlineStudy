package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Course;
// import cn.h4795.pojo.Course;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface CourseService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Course> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Course course);
	
	
	/**
	 * 修改
	 */
	public void update(Course course);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Course findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids) throws Exception;

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Course course, int pageNum, int pageSize);


	/**
	 * 根据分类查询课程
	 * @param kindId
	 * @return
	 */
	public PageResult  findByKindId(Integer kindId,int pageNum,int pageSize);

	/**
	 * 通过kindid删除course
	 * @param id
	 */
	public void deleteByParentId(Integer id);

	
}
