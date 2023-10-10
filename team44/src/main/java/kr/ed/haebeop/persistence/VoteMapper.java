package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Vote;
import kr.ed.haebeop.domain.VoteCountVo;
import kr.ed.haebeop.domain.VoteList;
import kr.ed.haebeop.domain.VoteUser;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VoteMapper {

    public List<Vote> voteAllList(Page page);

    public int totalCount(Page page);

    public List<Vote> voteAllListForAdmin(Page page);

    public int totalCountForAdmin(Page page);

    public Vote voteDetail(int vno);

    public void voteInsert(Vote vote);

    public void voteDelete(int vno);

    public void voteUpdateState(int vno);

    public void voteUpdateUse(int vno);

    public void voteEdit(Vote vote);

    public void voteVisitCount(int vno);

    public void voteFinalInsert(VoteCountVo voteCount);

    public List<VoteList> voteAnswerList(int vno);

    public void voteAnswerInsert(VoteList voteList);

    public void voteAnswerDelete(int lno);

    public void voteAllAnswerDelete(int vno);

    public void voteAnswerEdit(VoteList voteList);

    public List<Vote> voteMyList(String sid);

    public VoteUser voteUserList(VoteUser voteUser);

    public int voteUserCnt(int lno);

    public void voteUserInsert(VoteUser voteUser);

    public void voteUserDelete(VoteUser voteUser);

    public List<VoteCountVo> voteCountList(int vno);

    public VoteCountVo voteMaxCountList(int vno);

    public int voteCountCnt(int vno);

}
