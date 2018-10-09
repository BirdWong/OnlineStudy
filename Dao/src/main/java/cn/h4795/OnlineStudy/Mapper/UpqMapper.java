package cn.h4795.OnlineStudy.Mapper;

import cn.h4795.OnlineStudy.Pojo.Upq;
import cn.h4795.OnlineStudy.Pojo.UpqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpqMapper {
    int countByExample(UpqExample example);

    int deleteByExample(UpqExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Upq record);

    int insertSelective(Upq record);

    List<Upq> selectByExample(UpqExample example);

    Upq selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Upq record, @Param("example") UpqExample example);

    int updateByExample(@Param("record") Upq record, @Param("example") UpqExample example);

    int updateByPrimaryKeySelective(Upq record);

    int updateByPrimaryKey(Upq record);
}