package cn.h4795.OnlineStudy.Mapper;

import java.util.List;

import cn.h4795.OnlineStudy.Pojo.Personal;
import cn.h4795.OnlineStudy.Pojo.PersonalExample;
import org.apache.ibatis.annotations.Param;

public interface PersonalMapper {
    int countByExample(PersonalExample example);

    int deleteByExample(PersonalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Personal record);

    int insertSelective(Personal record);

    List<Personal> selectByExample(PersonalExample example);

    Personal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Personal record, @Param("example") PersonalExample example);

    int updateByExample(@Param("record") Personal record, @Param("example") PersonalExample example);

    int updateByPrimaryKeySelective(Personal record);

    int updateByPrimaryKey(Personal record);
}