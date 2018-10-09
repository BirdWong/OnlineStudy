package cn.h4795.OnlineStudy.controller;
import java.util.List;

import cn.h4795.OnlineStudy.Pojo.Category;
import cn.h4795.OnlineStudy.Pojo.Course;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.CategoryService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Reference
	private CategoryService categoryService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Category> findAll(){
		return categoryService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return categoryService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param category
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Category category){
		try {
			categoryService.add(category);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param category
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Category category){
		try {
			categoryService.update(category);
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
	public  Category findOne(Integer id){
		return categoryService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			categoryService.delete(ids);
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
	public PageResult search(@RequestBody  Category category, int page, int rows  ){
		return categoryService.findPage(category, page, rows);		
	}

	/**
	 * 通过课程的cid查询课程的目录列表
	 * @param cid
	 * @return
	 */
	@RequestMapping("/findByParentId")
	public List<Category> findByParentId(Integer cid){
		return categoryService.findByParentId(cid);
	}
	
}
