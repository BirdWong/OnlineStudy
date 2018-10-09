package cn.h4795.OnlineStudy.service;

import cn.h4795.OnlineStudy.Pojo.Course;
import cn.h4795.OnlineStudy.Pojo.Learningrecord;
import cn.h4795.OnlineStudy.Pojo.User;
import entity.PageResult;

import java.util.List;
import java.util.Map;

// import cn.h4795.pojo.Learningrecord;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface LearningrecordService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Learningrecord> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Learningrecord learningrecord);
	
	
	/**
	 * 修改
	 */
	public void update(Learningrecord learningrecord);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Learningrecord findOne(Integer id);
	
	
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
	public PageResult findPage(Learningrecord learningrecord, int pageNum, int pageSize);


	/**
	 * 通过course的id 查找学习了这个课程的用户
	 * @param id
	 * @return
	 */
	public PageResult findByCourseId(Integer id,int pageNum, int pageSize);

	/**
	 * 通过查询课程id 得到学习该课程的人数
	 * @param id
	 * @return
	 */
	public Integer countByCourseId(Integer id);

	/**
	 * 通过user的id查询这个用户学习过的课程记录
	 * @param id
	 * @return
	 */
	public PageResult findCourseByUserId(Integer id,int pageNum, int pageSize);

	/**
	 *通过user的id查询这个用户的学习方向kind
	 * @param id
	 * @return
	 */
	public PageResult findKindByUserId(Integer id,int pageNum, int pageSize);

	/**
	 * 通过user的id，得到学习的课程数量
	 * @param id
	 * @return
	 */
	public Integer countByUserId(Integer id);

	/**
	 * 通过用户id删除记录
	 * @param id
	 */
	public void deleteByUserId(Integer id);

	/**
	 * 通过课程id删除记录
	 * @param id
	 */
	public void deleteByCourseId(Integer id);
}
