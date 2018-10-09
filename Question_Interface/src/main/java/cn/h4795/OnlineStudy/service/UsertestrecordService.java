package cn.h4795.OnlineStudy.service;
import java.util.List;
import java.util.Map;

import cn.h4795.OnlineStudy.Pojo.GG;
import cn.h4795.OnlineStudy.Pojo.Usertestrecord;
// import cn.h4795.pojo.Usertestrecord;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UsertestrecordService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Usertestrecord> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Usertestrecord usertestrecord);
	
	
	/**
	 * 修改
	 */
	public void update(Usertestrecord usertestrecord);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Usertestrecord findOne(Integer id);
	
	
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
	public PageResult findPage(Usertestrecord usertestrecord, int pageNum, int pageSize);

	/**
	 * 通过User的id查询user的刷题题组
	 * @param id
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult findByUserId(Integer id ,int pageNum,int pageSize);

	/**
	 * t通过paper的id分页查询刷题的user人数
	 * @param id
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult findByPaperId(Integer id,int pageNum,int pageSize);


	/**
	 * 通过user的id查询这个用户做过多少题组
	 * @param id
	 * @return
	 */
	public Integer countByUser(Integer id);


	/**
	 * 通过paper的id查询这个题组有多少人刷
	 * @param id
	 * @return
	 */
	public Integer countByPaper(Integer id);

	/**
	 * 统计用户每个方向的题目刷过多少个
	 * @param uid
	 * @return
	 */

	public List<GG> studyPath(Integer uid);


	/**
	 * 上传用户分数
	 * @param uid
	 * @param pid
	 */
	public void submit(Integer uid,Integer pid,Integer score);


	/**
	 * 拿到一次测试的数据
	 * @param uid
	 * @param pid
	 * @return
	 */
	public Map TestOne(Integer uid,Integer pid);




}
