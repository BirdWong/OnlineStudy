package cn.h4795.OnlineStudy.controller;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.h4795.OnlineStudy.Pojo.Personal;
import cn.h4795.OnlineStudy.Pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.UserService;

import entity.PageResult;
import entity.Result;
import util.AlipayUtil;
import util.PhoneFormatCheckUtils;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Reference
	private UserService userService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return userService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param map
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Map<String,String> map){



		String code = (String) map.get("code");


		User user = new User();
		user.setUserphone((String) map.get("userphone"));
		user.setUserpassword((String) map.get("userpassword"));
		//校验验证码
		    if (!userService.checkSmsCode(user.getUserphone(),code)){
			return new Result(false,"验证码错误");
		}

		try {
			userService.add(user);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  User user){
		try {

			userService.update(user);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public  User findOne(Integer id){
		return userService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody  Integer [] ids){
		try {
			userService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");

		}
	}
	
		/**
	 * 查询+分页
	 * @param
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody  User user, int page, int rows  ){
		return userService.findPage(user, page, rows);		
	}


	@RequestMapping("/sendCode")
	public Result sendCode(@RequestBody String ctel){

		if (!judgeMoney(ctel)){
			return  new Result(false,"没有支付");
		}
		System.out.println("支付成功");
        	System.out.println(ctel);



        	if (!PhoneFormatCheckUtils.isPhoneLegal(ctel)){
		    return new Result(false,"手机格式不正确");
		}

		try {
			String message = userService.createSmsCode(ctel);
			if ("号码已注册".equals(message)){
			return new Result(false,message);
	  	  }
			return new Result(true,message);
        	}catch (Exception e){
			return new Result(false,"发送失败");
		}
	}


	@RequestMapping("/give")
	public Result money(@RequestBody  String ctel){
		AlipayUtil alipayUtil = new AlipayUtil();
		String shopId = ctel + System.currentTimeMillis()   + (long) (Math.random() * 10000000L);
		try {
			String execute = alipayUtil.execute(shopId, "学习平台", "1000", "测试");
			userService.sendMoney(ctel,shopId);
			return new Result(true,execute);
		} catch (IOException e) {

			e.printStackTrace();

		}
		return  new Result(false,"生成失败");
	}


	private boolean judgeMoney(String ctel){

		return  userService.judgeMoney(ctel);

	}


	
}
