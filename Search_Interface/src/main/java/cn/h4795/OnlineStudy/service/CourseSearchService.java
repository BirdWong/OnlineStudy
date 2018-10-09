package cn.h4795.OnlineStudy.service;


import cn.h4795.OnlineStudy.Pojo.CourseSolr;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/7/30 0030
 */
public interface CourseSearchService {

	/**
	 * 搜索方法
	 * @param searchMap
	 * @return
	 */
	public Map search(Map searchMap);


	/**
	 * 导入列表
	 * @param courseSolr
	 */
	public void importCourseSolr(CourseSolr courseSolr);

	/**
	 * 通过Course的id删除数据项
	 * @param courseId
	 */
	public void deleteByCourseId(Long courseId);


	/**
	 * 通过courseId的数组批量删除
	 * @param courseId
	 */
	public void deleteByCourseId(Long[] courseId);
}
