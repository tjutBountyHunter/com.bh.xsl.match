package xsl.match.mapper;

import com.xsl.pojo.XslHunterTag;
import com.xsl.pojo.XslHunterTagExample;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface XslHunterTagMapper {
    int countByExample(XslHunterTagExample example);

    int deleteByExample(XslHunterTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslHunterTag record);

    int insertSelective(XslHunterTag record);

    List<XslHunterTag> selectByExample(XslHunterTagExample example);

    XslHunterTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslHunterTag record, @Param("example") XslHunterTagExample example);

    int updateByExample(@Param("record") XslHunterTag record, @Param("example") XslHunterTagExample example);

    int updateByPrimaryKeySelective(XslHunterTag record);

    int updateByPrimaryKey(XslHunterTag record);

    List<XslHunterTag> getHuntersByTag(Integer task_id);

    List<XslHunterTag> getTagsByHunter(Integer hunter_id);

}