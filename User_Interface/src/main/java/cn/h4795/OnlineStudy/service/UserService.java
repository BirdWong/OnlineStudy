package cn.h4795.OnlineStudy.service;
import java.util.List;
import cn.h4795.OnlineStudy.Pojo.User;
// import cn.h4795.pojo.User;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<User> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(User user);
	
	
	/**
	 * 修改
	 */
	public void update(User user);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public User findOne(Integer id);
	
	
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
	public PageResult findPage(User user, int pageNum, int pageSize);


	/**
	 * 发送短信验证码
	 * @param ctel
	 */
	public String createSmsCode(String ctel);

	/**
	 * 验证码校验
	 * @param ctel
	 * @param code
	 * @return
	 */
	public boolean checkSmsCode(String ctel,String code);


	/**
	 * 通过手机账号查找用户
	 * @param ctel
	 * @return
	 */
	public User findByPhone(String ctel);


	/**
	 * 用户送钱
	 * @param ctel
	 * @return
	 */
	public String sendMoney(String ctel,String shopId);

	/**
	 * 校验是否交钱了
	 * @param ctel
	 * @return
	 */
	public boolean judgeMoney(String ctel);

}
