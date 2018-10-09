package cn.h4795.OnlineStudy.service.impl;

import cn.h4795.OnlineStudy.Pojo.CourseSolr;
import cn.h4795.OnlineStudy.service.CourseSearchService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 搜索的实现
 * @author Administrator
 * @date 2018/7/30 0030
 *
 * timeout：对应的是超时时间
 *
 * keywords：是搜索关键字
 * kind：种类过滤
 * pageNo：当前页码数（如果没有这个参数，默认首页）
 * pageSize：每页页码个数（如果没有这个参数，默认为20）
 */

@Service(timeout = 10000)
public class CourseSearchServiceImpl implements CourseSearchService {


	@Autowired
	private SolrTemplate solrTemplate;

	@Override
	public Map search(Map searchMap) {

        //空格处理
        String keywords  = (String)searchMap.get("keywords");
        //用空字符串“”   替换“ ”
        searchMap.put("keywords",keywords.replace(" ",""));

		Map map = new HashMap();
		//1、查询列表
		map.putAll(searchList(searchMap));
		//2、分组查询课程分类列表
		List<String> list = searchKindList(searchMap);
		map.put("kindList",list);
		return map;
	}




    //查询列表
	private  Map searchList(Map searchMap){

		Map map = new HashMap();
		/**
		 * 1、这是普通的利用复制域进行搜索
		 */
		/*

		Query query  = new SimpleQuery("*:*");
		Criteria criteria = new Criteria("course_keywords").is(searchMap.get("keywords"));
		query.addCriteria(criteria);
		ScoredPage<CourseSolr> page = solrTemplate.queryForPage(query,CourseSolr.class);
		map.put("rows",page.getContent());*/

		/**
		 * 2、这是利用复制域搜素后将要搜索的内容进行高亮
		 */


		//********************1.高亮选项设置**********************
		//	1.设置高亮对象
		//	<em style="color:red"> 查找的内容</em>
		HighlightQuery query = new SimpleHighlightQuery();
		//高亮在哪个内容上
		HighlightOptions highlightOptions = new HighlightOptions().addField("course_name").addField("course_kind").addField("course_description");
		//前缀
		highlightOptions.setSimplePrefix("<em style='color:red'>");
		//后缀
		highlightOptions.setSimplePostfix("</em>");
        //为查询对象设置高亮
		query.setHighlightOptions(highlightOptions);



		//***************2.关键字查询*********************
		Criteria criteria = new Criteria("course_keywords").is(searchMap.get("keywords"));
		query.addCriteria(criteria);



		//********************3.按照课程分类过滤*******************
        if (!"".equals(searchMap.get("kind")) && searchMap.get("kind")!=null){//如果用户选择了分类
            System.out.println(searchMap.get("kind"));
            FilterQuery filterquery = new SimpleFacetQuery();
            Criteria filterCriteria = new Criteria("course_kind").is(searchMap.get("kind"));
            filterquery.addCriteria(filterCriteria);
            query.addFilterQuery(filterquery);
        }


        //**********************4.分页********************************
        //获取当前页码
	Integer pageNo = Integer.valueOf((String) searchMap.get("pageNo"));
        if (pageNo == null || pageNo < 1){
            pageNo = 1;
        }
        Integer pageSize = Integer.valueOf((String) searchMap.get("pageSize"));
        if(pageSize == null || pageSize < 1){
            pageSize = 20;
        }
        //设置起始数
        query.setOffset((pageNo - 1)*pageSize);
        //设置每页的引索个数
        query.setRows(pageSize);


		//**********************5.获取高亮结果集************************
        //高亮页对象
        HighlightPage<CourseSolr> page = solrTemplate.queryForHighlightPage(query,CourseSolr.class);
        List<HighlightEntry<CourseSolr>> entries = page.getHighlighted();
		for(HighlightEntry<CourseSolr> entry :  entries){
			//获取高亮列表（高亮域的个数）
			List<HighlightEntry.Highlight>  highlightList = entry.getHighlights();
			if (highlightList.size() > 0 && highlightList.get(0).getSnipplets().size() > 0){
				CourseSolr courseSolr = entry.getEntity();
//				courseSolr.setKind(highlightList.get(0).getSnipplets().get(0));
//                courseSolr.setCname(highlightList.get(1).getSnipplets().get(0));
//                courseSolr.setCdescription(highlightList.get(2).getSnipplets().get(0));

                for (HighlightEntry.Highlight highlight : highlightList){
                    if(highlight.getField().getName().equals("course_kind")){
                        courseSolr.setKind(highlight.getSnipplets().get(0));
                    }else if(highlight.getField().getName().equals("course_name")){
                        courseSolr.setCname(highlight.getSnipplets().get(0));
                    }else if(highlight.getField().getName().equals("course_description")){
                        courseSolr.setCdescription(highlight.getSnipplets().get(0));
                    }
                }




			}
		}

		map.put("rows",page.getContent());
        //总页数
        map.put("totalPages",page.getTotalPages());
        //总条数
        map.put("total",page.getTotalElements());

		return map;
	}


	private List searchKindList(Map searchMap){
		List list = new ArrayList();

		Query query =  new SimpleQuery("*:*");
		//关键字查询where

		Criteria criteria = new Criteria("course_keywords").is(searchMap.get("keywords"));;
		query.addCriteria(criteria);
		//设置分组选项
		GroupOptions groupOptions = new GroupOptions().addGroupByField("course_kind");
		query.setGroupOptions(groupOptions);
		//获取分组页
		GroupPage<CourseSolr> page = solrTemplate.queryForGroupPage(query,CourseSolr.class);
		//获取分组结果对象
		GroupResult<CourseSolr> groupResult = page.getGroupResult("course_kind");
		//获取分组入口
		Page<GroupEntry<CourseSolr>> groupEntries = groupResult.getGroupEntries();
		//获取分组入口集合
		List<GroupEntry<CourseSolr>> entryList = groupEntries.getContent();

		for(GroupEntry<CourseSolr> entry:entryList){
			list.add(entry.getGroupValue());//将分组结果返回到结果中
		}


		return list;


	}


    /**
     * 导入列表
     * @param courseSolr
     */
    @Override
    public void importCourseSolr(CourseSolr courseSolr) {
        solrTemplate.saveBean(courseSolr);
        solrTemplate.commit();
    }

	/**
	 * 通过course的id删除数据项
	 * @param courseId
	 */
	@Override
    public void deleteByCourseId(Long courseId){
		delete(courseId);
	}

	/**
	 * 通过course的id删除数据项
	 * @param courseId
	 */
	@Override
	public void deleteByCourseId(Long[] courseId){
		for (Long id : courseId){
			delete(id);
		}
	}

	private void delete(Long courseId){
		Query query = new SimpleQuery("*:*");
		Criteria criteria = new Criteria("id").in(courseId);
		query.addCriteria(criteria);
		solrTemplate.delete(query);
		solrTemplate.commit();
	}
}
