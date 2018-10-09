package cn.h4795.OnlineStudy.controller;

import java.util.List;
import cn.h4795.OnlineStudy.Pojo.Problem;
import cn.h4795.OnlineStudy.Pojo.Question;
import cn.h4795.OnlineStudy.service.ProblemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.QuestionService;

import entity.PageResult;
import entity.Result;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Reference
	private QuestionService questionService;

	@Reference
	private ProblemService problemService;

	@Value("${FILE_SERVER_URL}")
	private String file_server_url;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Question> findAll(){
		return questionService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return questionService.findPage(page, rows);








	}
	
	/**
	 * 增加
	 * @param question
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Question question){
		try {

			questionService.add(question);


			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param question
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Question question){
		try {
			questionService.update(question);
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
	public  Question findOne(Integer id){
		return questionService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			questionService.delete(ids);
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
	public PageResult search(@RequestBody  Question question, int page, int rows  ){
		return questionService.findPage(question, page, rows);		
	}

	@RequestMapping(value = "/upload")
	public Result upload(@RequestBody MultipartFile file){
		//获取文件全名称
		String originalFilename = file.getOriginalFilename();
		//文件可能有很多个  .  分割所以取最后一个
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
		try {
			FastDFSClient client = new FastDFSClient("classpath:config/fdfs_client.conf");
			String[] information = client.uploadFile(file.getBytes(),extName);
			String fileId = information[0] + "/" +information[1];
			//图片完整地址
			String url = file_server_url + fileId;
			return new Result(true,url);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"error");
		}
	}
	
}
