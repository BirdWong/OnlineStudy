package cn.h4795.OnlineStudy.controller;
import java.util.List;

import cn.h4795.OnlineStudy.Pojo.Message;
import cn.h4795.OnlineStudy.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.MessageService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/message")
public class MessageController {

	@Reference
	private MessageService messageService;

	@Reference
	private UserService userService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Message> findAll(){
		return messageService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return messageService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param message
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Message message){
		if((userService.findOne(message.getGetid()) == null ) || (userService.findOne(message.getSendid()) == null)){
			return new Result(false,"查无此用户");
		}
		try {
			messageService.add(message);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param message
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Message message){
		try {
			messageService.update(message);
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
	public  Message findOne(Integer id){
		return messageService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			messageService.delete(ids);
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
	public PageResult search(@RequestBody  Message message, int page, int rows  ){
		return messageService.findPage(message, page, rows);		
	}
	
}
