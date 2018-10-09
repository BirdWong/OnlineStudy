package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Vidio;
// import cn.h4795.pojo.Vidio;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface VidioService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Vidio> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Vidio vidio);
	
	
	/**
	 * 修改
	 */
	public void update(Vidio vidio);
	

	/**
	 * 根据ID获取实体
	 * @param
	 * @return
	 */
	public Vidio findOne(Integer vid);
	
	
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
	public PageResult findPage(Vidio vidio, int pageNum, int pageSize);

	/**
	 * 通过章节id删除视频
	 * @param id
	 */
	public void deleteByCategoryId(Integer id);


	/**
	 * 通过category获取视频
	 * @param cid
	 * @param uid
	 * @return
	 */
	public Vidio findByCategoryId(Integer cid,Integer uid);



}
