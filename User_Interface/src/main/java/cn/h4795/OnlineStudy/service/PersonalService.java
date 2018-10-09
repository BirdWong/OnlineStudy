package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Personal;
// import cn.h4795.pojo.Personal;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface PersonalService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Personal> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Personal personal);
	
	
	/**
	 * 修改
	 */
	public void update(Personal personal);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Personal findOne(Integer id);
	
	
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
	public PageResult findPage(Personal personal, int pageNum, int pageSize);

	/**
	 * 通过父类userID查询
	 * @param id
	 * @return
	 */
	public Personal findByParentId(Integer id);
	
}
