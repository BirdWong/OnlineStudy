package cn.h4795.OnlineStudy.controller;
import java.util.List;
import java.util.Map;

import cn.h4795.OnlineStudy.Pojo.Learningrecord;
import cn.h4795.OnlineStudy.Pojo.User;
import cn.h4795.OnlineStudy.service.LearningrecordService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/learningrecord")
public class LearningrecordController {

	@Reference
	private LearningrecordService learningrecordService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Learningrecord> findAll(){
		return learningrecordService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return learningrecordService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param learningrecord
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Learningrecord learningrecord){
		try {
			learningrecordService.add(learningrecord);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param learningrecord
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Learningrecord learningrecord){
		try {
			learningrecordService.update(learningrecord);
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
	public  Learningrecord findOne(Integer id){
		return learningrecordService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			learningrecordService.delete(ids);
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
	public PageResult search(@RequestBody  Learningrecord learningrecord, int page, int rows  ){
		return learningrecordService.findPage(learningrecord, page, rows);		
	}



	/**
	 * 通过course的id 查找学习了这个课程的用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/findByCourseId")
	public PageResult findByCourseId(Integer id,int pageNum, int pageSize){
		PageResult learningrecordServiceByCourseId = learningrecordService.findByCourseId(id, pageNum, pageSize);
		return learningrecordServiceByCourseId;
	}

	/**
	 * 通过查询课程id 得到学习该课程的人数
	 * @param id
	 * @return
	 */
	@RequestMapping("/countByCourseId")
	public Integer countByCourseId(Integer id){
		Integer count = learningrecordService.countByCourseId(id);
		return count;
	}

	/**
	 * 通过user的id查询这个用户学习过的Course记录
	 * @param id
	 * @return
	 */
	@RequestMapping("/findCourseByUserId")
	public PageResult findCourseByUserId(Integer id,int pageNum, int pageSize){
		PageResult courseByUserId = learningrecordService.findCourseByUserId(id,pageNum,pageSize);
		return courseByUserId;
	}

	/**
	 * 通过user的id查询这个用户学习方向kind
	 * @param id
	 * @return
	 */
	@RequestMapping("/findKindByUserId")
	public PageResult findKindByUserId(Integer id,int pageNum, int pageSize){
		PageResult courseByUserId = learningrecordService.findKindByUserId(id,pageNum,pageSize);
		return courseByUserId;
	}

	/**
	 * 通过user的id，得到学习的课程数量
	 * @param id
	 * @return
	 */
	@RequestMapping("/countByUserId")
	public Integer countByUserId(Integer id){
		Integer count = learningrecordService.countByUserId(id);
		return count;
	}
	
}
