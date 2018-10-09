package cn.h4795.OnlineStudy.Mapper;

import java.util.List;

import cn.h4795.OnlineStudy.Pojo.Barrage;
import cn.h4795.OnlineStudy.Pojo.BarrageExample;
import org.apache.ibatis.annotations.Param;

public interface BarrageMapper {
    int countByExample(BarrageExample example);

    int deleteByExample(BarrageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    List<Barrage> selectByExample(BarrageExample example);

    Barrage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByExample(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);
}