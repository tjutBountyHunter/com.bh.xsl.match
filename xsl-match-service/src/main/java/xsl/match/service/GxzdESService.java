package xsl.match.service;

import com.xsl.search.export.vo.MatchSearchVo;
import com.xsl.search.export.vo.MatchTeamSearchVo;
import com.xsl.search.export.vo.MatchUserSearchVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GxzdSearchService
 * @Description 搜索系统相关
 * @Author 11432
 * @DATE 2019/6/1 12:08
 */
@Service
public interface GxzdESService {
    /** 查找比赛、队伍、用户 */
    List<MatchSearchVo> searchMatch(String keyWord, List<String> ids, Integer size)throws RuntimeException;
    List<MatchTeamSearchVo> searchTeam(String keyWord, List<String> ids, Integer size)throws RuntimeException;
    List<MatchUserSearchVo> searchUser(String keyWord, List<String> ids, Integer size)throws RuntimeException;
    /** 添加数据 */
    boolean addUser(MatchUserSearchVo matchUserSearchVo)throws RuntimeException;
    boolean addMatch(MatchSearchVo matchSearchVo)throws RuntimeException;
    boolean addTeam(MatchTeamSearchVo matchTeamSearchVo)throws RuntimeException;
    /** 删除数据 */
    boolean removeUser(String hunterId)throws RuntimeException;
    boolean removeMatch(String matchId)throws RuntimeException;
    boolean removeTeam(String teamId)throws RuntimeException;
}
