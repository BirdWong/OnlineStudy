package cn.h4795.OnlineStudy.controller;
import java.util.List;

import cn.h4795.OnlineStudy.Pojo.Kind;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.KindService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/kind")
public class KindController {

	@Reference
	private KindService kindService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Kind> findAll(){
		return kindService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return kindService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param kind
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Kind kind){
		try {
			kindService.add(kind);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param kind
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Kind kind){
		try {
			kindService.update(kind);
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
	public  Kind findOne(Integer id){
		return kindService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			kindService.delete(ids);
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
	public PageResult search(@RequestBody  Kind kind, int page, int rows  ){
		return kindService.findPage(kind, page, rows);		
	}
	
}
