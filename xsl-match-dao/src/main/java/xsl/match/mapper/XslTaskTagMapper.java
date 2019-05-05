package xsl.match.mapper;

import com.xsl.pojo.XslTaskTag;
import com.xsl.pojo.Example.XslTaskTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslTaskTagMapper {
    long countByExample(XslTaskTagExample example);

    int deleteByExample(XslTaskTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslTaskTag record);

    int insertSelective(XslTaskTag record);

    List<XslTaskTag> selectByExample(XslTaskTagExample example);

    XslTaskTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslTaskTag record, @Param("example") XslTaskTagExample example);

    int updateByExample(@Param("record") XslTaskTag record, @Param("example") XslTaskTagExample example);

    int updateByPrimaryKeySelective(XslTaskTag record);

    int updateByPrimaryKey(XslTaskTag record);

    /** 自定义 */
    List<XslTaskTag> getTagsByTaskId(String taskId);

    List<XslTaskTag> getTasksByTagId(String taskTag);
}