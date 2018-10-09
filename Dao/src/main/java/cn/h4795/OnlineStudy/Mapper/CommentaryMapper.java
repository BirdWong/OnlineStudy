package cn.h4795.OnlineStudy.Mapper;

import cn.h4795.OnlineStudy.Pojo.Commentary;
import cn.h4795.OnlineStudy.Pojo.CommentaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentaryMapper {
    int countByExample(CommentaryExample example);

    int deleteByExample(CommentaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Commentary record);

    int insertSelective(Commentary record);

    List<Commentary> selectByExample(CommentaryExample example);

    Commentary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Commentary record, @Param("example") CommentaryExample example);

    int updateByExample(@Param("record") Commentary record, @Param("example") CommentaryExample example);

    int updateByPrimaryKeySelective(Commentary record);

    int updateByPrimaryKey(Commentary record);
}