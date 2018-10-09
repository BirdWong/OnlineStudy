package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Barrage;
// import cn.h4795.pojo.Barrage;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface BarrageService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Barrage> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Barrage barrage);
	
	
	/**
	 * 修改
	 */
	public void update(Barrage barrage);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Barrage findOne(Integer id);
	
	
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
	public PageResult findPage(Barrage barrage, int pageNum, int pageSize);


	/**
	 * 通过视频id删除弹幕
	 * @param id
	 */
	public void deleteByParentId(Integer id);
	
}
