package cn.h4795.OnlineStudy.Mapper;

import java.util.List;

import cn.h4795.OnlineStudy.Pojo.Vidio;
import cn.h4795.OnlineStudy.Pojo.VidioExample;
import org.apache.ibatis.annotations.Param;

public interface VidioMapper {
    int countByExample(VidioExample example);

    int deleteByExample(VidioExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Vidio record);

    int insertSelective(Vidio record);

    List<Vidio> selectByExample(VidioExample example);

    Vidio selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Vidio record, @Param("example") VidioExample example);

    int updateByExample(@Param("record") Vidio record, @Param("example") VidioExample example);

    int updateByPrimaryKeySelective(Vidio record);

    int updateByPrimaryKey(Vidio record);
}