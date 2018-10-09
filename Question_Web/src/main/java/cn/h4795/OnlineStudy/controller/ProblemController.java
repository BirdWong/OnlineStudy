package cn.h4795.OnlineStudy.controller;

import cn.h4795.OnlineStudy.Pojo.Problem;
import cn.h4795.OnlineStudy.service.ProblemService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/8/8 0008
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

	@Reference
	private ProblemService problemService;


	/**
	 * 添加题目，分别添加question和choice
	 * @param problem
	 */
	@RequestMapping("/add")
	public void add(@RequestBody  Problem problem){

		problemService.add(problem);
	}

	/**
	 * 删除题目，需要删除choice和question
	 *
	 * ids为question的id
	 * @param ids
	 */
	@RequestMapping("/delete")
	public void delete(@RequestBody  Integer[] ids){
		problemService.delete(ids);
	}

	/**
	 * 通过paper 的id删除一个列表的question 和 choice
	 * @param id
	 */
	@RequestMapping("/deleteByPaper")
	public void deleteByPaper(Integer id){
		problemService.deleteByPaper(id);
	}

	/**
	 * 通过question的id返回一个完整的题目
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Problem findOne(Integer id){

		return  problemService.findOne(id);
	}

	/**
	 * 通过paper的id返回一个题目列表
	 * @param
	 * @return
	 */
	@RequestMapping("/findByPaperId")
	public List<Problem> findByPaperId(Integer pid,Integer uid){


		return  problemService.findByPaperId(pid,uid);

	}




}
