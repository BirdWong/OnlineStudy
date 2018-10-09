package cn.h4795.OnlineStudy.service.impl;

import cn.h4795.OnlineStudy.service.CourseSearchService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @author h4795
 * @project OnlineStudy
 * @date 2018-08-03-11
 */
@Component
public class CourseSearchDeleteListener implements MessageListener {

    @Autowired
    private CourseSearchService searchService;

    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        try {
            Long id = (Long) objectMessage.getObject();
            searchService.deleteByCourseId(id);

            System.out.println("从solr删除");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
