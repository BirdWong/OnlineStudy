package cn.h4795.OnlineStudy.controller;
import java.util.Date;
import java.util.List;

import cn.h4795.OnlineStudy.Mapper.*;
import cn.h4795.OnlineStudy.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.VidioService;

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
@RequestMapping("/vidio")
public class VidioController {

	@Value("${FILE_SERVER_URL}")
	private String file_server_url;

	@Reference
	private VidioService vidioService;





	@RequestMapping(value = "/upload")
	public Result upload(@RequestBody  MultipartFile file){
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

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Vidio> findAll(){
		return vidioService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return vidioService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param vidio
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Vidio vidio){


		try {
			vidioService.add(vidio);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param vidio
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Vidio vidio){
		try {
			vidioService.update(vidio);
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
	public  Vidio findOne(Integer id){

		Vidio vidio = vidioService.findOne(id);

		return vidio;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			vidioService.delete(ids);
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
	public PageResult search(@RequestBody  Vidio vidio, int page, int rows  ){
		return vidioService.findPage(vidio, page, rows);		
	}


	@RequestMapping("/findByCategoryId")
	public Vidio findByCategoryId(Integer cid,Integer uid){
		return vidioService.findByCategoryId(cid,uid);
	}
}
