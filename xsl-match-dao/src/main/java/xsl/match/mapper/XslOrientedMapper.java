package xsl.match.mapper;


import com.xsl.pojo.XslOriented;

import java.util.List;

public interface XslOrientedMapper {
    List<XslOriented> selectAll();

    int insert(XslOriented xslOriented);

    int deleteByOrientedId(String orientedId);

    int updateByOrientedId(XslOriented xslOriented);

    int updateOrientedStateByOrientedId(XslOriented xslOriented);
}