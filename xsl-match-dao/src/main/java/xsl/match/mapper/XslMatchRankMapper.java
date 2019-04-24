package xsl.match.mapper;


import com.xsl.pojo.XslMatchRank;


import java.util.List;

public interface XslMatchRankMapper {

    List<XslMatchRank> selectAll();

    List<XslMatchRank> selectByRankId(Integer rankId);

    int updateByRankId(XslMatchRank xslMatchRank);

    int insert(XslMatchRank xslMatchRank);

    int deleteByMatchRankId(String matchRankId);
}