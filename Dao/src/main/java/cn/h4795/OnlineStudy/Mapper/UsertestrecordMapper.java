package cn.h4795.OnlineStudy.Mapper;

import cn.h4795.OnlineStudy.Pojo.Usertestrecord;
import cn.h4795.OnlineStudy.Pojo.UsertestrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsertestrecordMapper {
    int countByExample(UsertestrecordExample example);

    int deleteByExample(UsertestrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usertestrecord record);

    int insertSelective(Usertestrecord record);

    List<Usertestrecord> selectByExample(UsertestrecordExample example);

    Usertestrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usertestrecord record, @Param("example") UsertestrecordExample example);

    int updateByExample(@Param("record") Usertestrecord record, @Param("example") UsertestrecordExample example);

    int updateByPrimaryKeySelective(Usertestrecord record);

    int updateByPrimaryKey(Usertestrecord record);
}