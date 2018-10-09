package cn.h4795.OnlineStudy.controller;

import cn.h4795.OnlineStudy.service.CourseSearchService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Administrator
 * @date 2018/7/30 0030
 */
@RestController
@RequestMapping("/CourseSearch")
public class SearchController {


	/**
	 *  timeout: dubbox 超时设置
	 *  超时设置推荐放在服务端
	 *  如果连端都配置了， 以消费端的设置为准
	 *  @Reference(timeout = 5000)
	 */
	@Reference
	private CourseSearchService searchService;

	@RequestMapping("/search")
	public Map search(@RequestBody Map<String,String> searchMap){


		return searchService.search(searchMap);
	}
}
