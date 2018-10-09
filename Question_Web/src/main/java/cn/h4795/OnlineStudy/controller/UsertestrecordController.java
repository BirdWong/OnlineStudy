package cn.h4795.OnlineStudy.controller;
import java.util.List;
import java.util.Map;

import cn.h4795.OnlineStudy.Pojo.GG;
import cn.h4795.OnlineStudy.Pojo.Usertestrecord;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.UsertestrecordService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/usertestrecord")
public class UsertestrecordController {

	@Reference
	private UsertestrecordService usertestrecordService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Usertestrecord> findAll(){
		return usertestrecordService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return usertestrecordService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param usertestrecord
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Usertestrecord usertestrecord){
		try {
			usertestrecordService.add(usertestrecord);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param usertestrecord
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Usertestrecord usertestrecord){
		try {
			usertestrecordService.update(usertestrecord);
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
	public  Usertestrecord findOne(Integer id){
		return usertestrecordService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			usertestrecordService.delete(ids);
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
	public PageResult search(@RequestBody  Usertestrecord usertestrecord, int page, int rows  ){
		return usertestrecordService.findPage(usertestrecord, page, rows);		
	}


	@RequestMapping("/submit")
	public Result submit(Integer uid,Integer pid,Integer score){
		try{
			usertestrecordService.submit(uid,pid,score);
			return  new Result(true,"上传成功");
		}catch (Exception e){
			return new Result(false,"上传失败");
		}
	}




	@RequestMapping("/studyPath")
	public List<GG> studyPath(Integer uid){
		return usertestrecordService.studyPath(uid);
	}



	@RequestMapping("/testOne")
	public Map TestOne(Integer uid, Integer pid){
		return usertestrecordService.TestOne(uid,pid);
	}
}
