package xsl.match.service.impl;

import com.xsl.search.export.GxzdAddSearchResource;
import com.xsl.search.export.GxzdRemoveSearchResource;
import com.xsl.search.export.GxzdSearchResource;
import com.xsl.search.export.vo.MatchSearchVo;
import com.xsl.search.export.vo.MatchTeamSearchVo;
import com.xsl.search.export.vo.MatchUserSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.service.GxzdESService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName GxzdSearchServiceImpl
 * @Description 搜索和对搜索库的数据维护
 * @Author 11432
 * @DATE 2019/6/1 12:16
 */
@Service
public class GxzdESServiceImpl implements GxzdESService {

    @Resource
    private GxzdSearchResource gxzdSearchService;
    @Resource
    private GxzdAddSearchResource gxzdAddSearchService;
    @Resource
    private GxzdRemoveSearchResource gxzdRemoveSearchService;

    @Override
    public List<MatchSearchVo> searchMatch(String keyWord, List<String> ids, Integer size) throws RuntimeException {
        List<MatchSearchVo> matchSearchVos = gxzdSearchService.searchMatch(keyWord, ids, size);
        return matchSearchVos;
    }

    @Override
    public List<MatchTeamSearchVo> searchTeam(String keyWord, List<String> ids, Integer size) throws RuntimeException {
        List<MatchTeamSearchVo> matchTeamSearchVos = gxzdSearchService.searchMatchTeam(keyWord, ids, size);
        return matchTeamSearchVos;
    }

    @Override
    public List<MatchUserSearchVo> searchUser(String keyWord, List<String> ids, Integer size) throws RuntimeException {
        List<MatchUserSearchVo> matchUserSearchVos = gxzdSearchService.searchMatchUser(keyWord, ids, size);
        return matchUserSearchVos;
    }

    @Override
    public boolean addUser(MatchUserSearchVo matchUserSearchVo) throws RuntimeException {
        boolean isSuccess = gxzdAddSearchService.addMatchUser(matchUserSearchVo);
        return isSuccess;
    }

    @Override
    public boolean addMatch(MatchSearchVo matchSearchVo) throws RuntimeException {
        boolean isSuccess = gxzdAddSearchService.addMatch(matchSearchVo);
        return isSuccess;
    }

    @Override
    public boolean addTeam(MatchTeamSearchVo matchTeamSearchVo) throws RuntimeException {
        boolean isSuccess = gxzdAddSearchService.addMatchTeam(matchTeamSearchVo);
        return isSuccess;    }

    @Override
    public boolean removeUser(String hunterId) throws RuntimeException {
        boolean isSuccess = gxzdRemoveSearchService.removeMatchUser(hunterId);
        return isSuccess;
    }

    @Override
    public boolean removeMatch(String matchId) throws RuntimeException {
        boolean isSuccess = gxzdRemoveSearchService.removeMatch(matchId);
        return isSuccess;
    }

    @Override
    public boolean removeTeam(String teamId) throws RuntimeException {
        boolean isSuccess = gxzdRemoveSearchService.removeMatchTeam(teamId);
        return isSuccess;
    }
}
