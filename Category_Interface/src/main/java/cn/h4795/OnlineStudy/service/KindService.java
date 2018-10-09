package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Kind;
// import cn.h4795.pojo.Kind;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface KindService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Kind> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Kind kind);
	
	
	/**
	 * 修改
	 */
	public void update(Kind kind);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Kind findOne(Integer id);
	
	
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
	public PageResult findPage(Kind kind, int pageNum, int pageSize);
	
}
