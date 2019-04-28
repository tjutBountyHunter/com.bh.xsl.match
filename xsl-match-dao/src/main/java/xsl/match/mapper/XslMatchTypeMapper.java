package xsl.match.mapper;

import com.xsl.pojo.XslMatchType;

import java.util.List;

public interface XslMatchTypeMapper {
    List<XslMatchType> selectAllMatchType();

    XslMatchType selectMatchTypeByMatchTypeId(String matchTypeId);

    int insert(XslMatchType xslMatchType);

    int updateByMatchTypeId(XslMatchType xslMatchType);

    int deleteByMatchTypeId(String matchTypeId);

    int updateTypeStateByMatchTypeId(XslMatchType xslMatchType);
}