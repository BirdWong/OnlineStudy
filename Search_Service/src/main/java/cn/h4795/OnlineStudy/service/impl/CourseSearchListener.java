package cn.h4795.OnlineStudy.service.impl;

import cn.h4795.OnlineStudy.Pojo.CourseSolr;
import cn.h4795.OnlineStudy.service.CourseSearchService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.List;

/**
 * @author h4795
 * @project OnlineStudy
 * @date 2018-08-03-10
 */
@Component
public class CourseSearchListener implements MessageListener {

    @Autowired
    private CourseSearchService courseSearchService;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String text = textMessage.getText();
            List<CourseSolr> courseSolrList = JSON.parseArray(text, CourseSolr.class);
            for(CourseSolr courseSolr : courseSolrList){
                courseSearchService.importCourseSolr(courseSolr);
            }
            System.out.println("导入到solr");


        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
