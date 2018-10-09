package cn.h4795.OnlineStudy.controller;
import java.util.List;

import cn.h4795.OnlineStudy.Pojo.Upq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.UpqService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/upq")
public class UpqController {

	@Reference
	private UpqService upqService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Upq> findAll(){
		return upqService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return upqService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param upq
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Upq upq){
		try {
			upqService.add(upq);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	@RequestMapping("/addList")
	public Result addList(@RequestBody List upqList){
		try {
			upqService.addList(upqList);
			return new Result(true, "增加成功");
		}catch (Exception e){
			return new Result(false, "增加失败");
		}
	}
	/**
	 * 修改
	 * @param upq
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Upq upq){
		try {
			upqService.update(upq);
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
	public  Upq findOne(Integer id){
		return upqService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			upqService.delete(ids);
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
	public PageResult search(@RequestBody  Upq upq, int page, int rows  ){
		return upqService.findPage(upq, page, rows);		
	}




}
