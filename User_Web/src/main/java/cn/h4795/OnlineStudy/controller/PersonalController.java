package cn.h4795.OnlineStudy.controller;
import java.util.List;
import java.util.Map;

import cn.h4795.OnlineStudy.Pojo.Personal;
import cn.h4795.OnlineStudy.Pojo.User;
import cn.h4795.OnlineStudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.h4795.OnlineStudy.service.PersonalService;

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
@RequestMapping("/personal")
public class PersonalController {


	@Value("${FILE_SERVER_URL}")
	private String file_server_url;


	@Reference
	private PersonalService personalService;

	@Reference
    private UserService userService;



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
	public List<Personal> findAll(){
		return personalService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return personalService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param personal
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody  Personal personal){



		try {
			personalService.add(personal);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param personal
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody  Personal personal){


		try {
			personalService.update(personal);
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
	public  Personal findOne(Integer id){
		return personalService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			personalService.delete(ids);
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
	public PageResult search(@RequestBody  Personal personal, int page, int rows  ){
		return personalService.findPage(personal, page, rows);		
	}

    /**
     * 登陆后获取用户信息
     * @return
     */
	@RequestMapping("/login")
	public Personal sendName(){

		return toLogin();
    }

    @RequestMapping("/toLogin")
    public Personal toLogin(){

	    String name = SecurityContextHolder.getContext().getAuthentication().getName();
	    System.out.println(name);
	    Personal personal = null;
	    if ("anonymousUser".equals(name)){
		    personal = new Personal();

		    personal.setPname("请先登录");

	    }else {
		    User user = userService.findByPhone(name);
		    personal = personalService.findByParentId(user.getId());
	    }
		return  personal;
    }


	/**
	 * 通过用户id返回用户数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/findByParentId")
	public Personal findByParentId(Integer id){
		return personalService.findByParentId(id);
    }
	
}
