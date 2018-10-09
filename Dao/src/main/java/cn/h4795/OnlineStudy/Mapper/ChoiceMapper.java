package cn.h4795.OnlineStudy.Mapper;

import cn.h4795.OnlineStudy.Pojo.Choice;
import cn.h4795.OnlineStudy.Pojo.ChoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChoiceMapper {
    int countByExample(ChoiceExample example);

    int deleteByExample(ChoiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Choice record);

    int insertSelective(Choice record);

    List<Choice> selectByExample(ChoiceExample example);

    Choice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Choice record, @Param("example") ChoiceExample example);

    int updateByExample(@Param("record") Choice record, @Param("example") ChoiceExample example);

    int updateByPrimaryKeySelective(Choice record);

    int updateByPrimaryKey(Choice record);
}