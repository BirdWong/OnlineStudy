package cn.h4795.OnlineStudy.controller;
import java.util.List;

import cn.h4795.OnlineStudy.Pojo.Commentary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.CommentaryService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/commentary")
public class CommentaryController {

	@Reference
	private CommentaryService commentaryService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Commentary> findAll(){
		return commentaryService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return commentaryService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param commentary
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Commentary commentary){
		try {
			commentaryService.add(commentary);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param commentary
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Commentary commentary){
		try {
			commentaryService.update(commentary);
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
	public  Commentary findOne(Integer id){
		return commentaryService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody  Integer [] ids){
		try {
			commentaryService.delete(ids);
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
	public PageResult search(@RequestBody  Commentary commentary, int page, int rows  ){
		return commentaryService.findPage(commentary, page, rows);		
	}


	/**
	 * 通过课程id查找评论
	 * @param id
	 * @return
	 */
	@RequestMapping("/findByCourseId")
	public List<Commentary> findByCourseId(Integer id){
		return commentaryService.findByCourseId(id);
	}
	
}
