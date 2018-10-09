package cn.h4795.OnlineStudy.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.h4795.OnlineStudy.Mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.h4795.OnlineStudy.Pojo.User;
import cn.h4795.OnlineStudy.Pojo.UserExample;
import cn.h4795.OnlineStudy.Pojo.UserExample.Criteria;

import cn.h4795.OnlineStudy.service.UserService;

import entity.PageResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import util.AlipayUtil;

import javax.jms.*;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout = 10000)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;


	@Autowired
	private RedisTemplate redisTemplete;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination smsDestination;

	
	/**
	 * 查询全部
	 */
	@Override
	public List< User> findAll() {
		return userMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page< User> page=   (Page< User>) userMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * //		passwordEncoder.matches(passwordFromInput,passwordFromDB);

	 * 增加
	 */
	@Override
	public void add(User user) {

		String md5Hex = DigestUtils.md5Hex(user.getUserpassword());//密码加密
		user.setUserpassword(md5Hex);

		userMapper.insert(user);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update( User user){
		userMapper.updateByPrimaryKey(user);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public  User findOne(Integer id){
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			userMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage( User user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		 UserExample example=new  UserExample();
		Criteria criteria = example.createCriteria();
		
		if(user!=null){			
						if(user.getUserpassword()!=null && user.getUserpassword().length()>0){
				criteria.andUserpasswordLike("%"+user.getUserpassword()+"%");
			}
			if(user.getUseremail()!=null && user.getUseremail().length()>0){
				criteria.andUseremailLike("%"+user.getUseremail()+"%");
			}
			if(user.getUserphone()!=null && user.getUserphone().length()>0){
				criteria.andUserphoneLike("%"+user.getUserphone()+"%");
			}
	
		}
		
		Page< User> page= (Page< User>)userMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public String createSmsCode(String ctel) {

		UserExample example = new UserExample();

		Criteria criteria = example.createCriteria();

		criteria.andUserphoneEqualTo(ctel);

		List<User> users = userMapper.selectByExample(example);

		if (!users.isEmpty()){
			return "号码已注册";
		}


		//生成6位数验证码
		String smscode = (long)(Math.random()*1000000)+"";

		//将验证码放入缓存
		redisTemplete.boundHashOps("smscode").put(ctel,smscode);

		System.out.println((String)redisTemplete.boundHashOps("smscode").get(ctel));
		//将短信内容发送给activemq
		jmsTemplate.send(smsDestination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setString("ctel",ctel);
				mapMessage.setString("code",smscode);
				return mapMessage;
			}
		});
		return "发送成功";

	}

	@Override
	public boolean checkSmsCode(String ctel, String code) {

		System.out.println(ctel);
		String smscode = (String) redisTemplete.boundHashOps("smscode").get(ctel);
		if (smscode==null){
			return  false;
		}
		if (!smscode.equals(code)){
			return false;
		}
		redisTemplete.boundHashOps("smscode").delete(ctel);
		return true;
	}

	@Override
	public User findByPhone(String ctel) {

		UserExample example = new UserExample();

		Criteria criteria = example.createCriteria();

		criteria.andUserphoneEqualTo(ctel);

		List<User> users = userMapper.selectByExample(example);
		User user = null;

		try{
			user = users.get(0);
		}catch (Exception e){
			System.out.println("没有这个用户");
		}
		return user;
	}

	@Override
	public String sendMoney(String ctel,String shopId) {
		if (redisTemplete.hasKey("alipay")) {
			if (redisTemplete.boundHashOps("alipay").hasKey(ctel)) {
				redisTemplete.boundHashOps("alipay").delete(ctel);
			}
		}
		redisTemplete.boundHashOps("alipay").put(ctel,shopId);
		System.out.println(ctel);
		System.out.println(redisTemplete.boundHashOps("alipay").get(ctel));;
		return "OK";
	}


	@Override
	public boolean judgeMoney(String ctel) {
		if (redisTemplete.hasKey("alipay")){
			if (redisTemplete.boundHashOps("alipay").hasKey(ctel)){
				AlipayUtil alipayUtil = new AlipayUtil();
				return alipayUtil.test_trade_query((String) redisTemplete.boundHashOps("alipay").get(ctel));
			}
		}
		return  false;
	}
}
