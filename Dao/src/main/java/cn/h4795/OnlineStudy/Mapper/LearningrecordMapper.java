package cn.h4795.OnlineStudy.Mapper;

import cn.h4795.OnlineStudy.Pojo.Learningrecord;
import cn.h4795.OnlineStudy.Pojo.LearningrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LearningrecordMapper {
    int countByExample(LearningrecordExample example);

    int deleteByExample(LearningrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Learningrecord record);

    int insertSelective(Learningrecord record);

    List<Learningrecord> selectByExample(LearningrecordExample example);

    Learningrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Learningrecord record, @Param("example") LearningrecordExample example);

    int updateByExample(@Param("record") Learningrecord record, @Param("example") LearningrecordExample example);

    int updateByPrimaryKeySelective(Learningrecord record);

    int updateByPrimaryKey(Learningrecord record);
}