package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Vote;
import kr.ed.haebeop.domain.VoteCountVo;
import kr.ed.haebeop.domain.VoteList;
import kr.ed.haebeop.domain.VoteUser;
import kr.ed.haebeop.persistence.VoteMapper;

import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl extends VoteList implements VoteService {

    @Autowired
    private VoteMapper voteRepo;

    @Override
    public List<Vote> voteAllList(Page page) throws Exception {
        return voteRepo.voteAllList(page);
    }

    @Override
    public int totalCount(Page page) throws Exception {
        return voteRepo.totalCount(page);
    }

    @Override
    public List<Vote> voteAllListForAdmin(Page page) throws Exception {
        return voteRepo.voteAllListForAdmin(page);
    }

    @Override
    public int totalCountForAdmin(Page page) throws Exception {
        return voteRepo.totalCountForAdmin(page);
    }

    @Override
    public Vote voteDetail(int vno) throws Exception {
        return voteRepo.voteDetail(vno);
    }

    @Override
    public void voteInsert(Vote vote) throws Exception {
        voteRepo.voteInsert(vote);
    }

    @Override
    public void voteDelete(int vno) throws Exception {
        Vote vote = voteRepo.voteDetail(vno);
        if(vote.isUseYn()) {
            List<VoteList> voteList = voteRepo.voteAnswerList(vno);
            for (VoteList voteAnswer: voteList) {
                int lno = voteAnswer.getLno();
                int cnt = voteRepo.voteUserCnt(lno);
                if(cnt > 0){
                    VoteUser voteUser = new VoteUser();
                    voteUser.setVno(vno);
                    voteUser.setLno(lno);
                    voteRepo.voteUserDelete(voteUser);
                }
            }
            voteRepo.voteAllAnswerDelete(vno);
        }
        voteRepo.voteDelete(vno);
    }

    @Override
    public void voteUpdateState(int vno) throws Exception {
        voteRepo.voteUpdateState(vno);
    }

    @Override
    public void voteUpdateUse(int vno) throws Exception {
        voteRepo.voteUpdateUse(vno);
    }

    @Override
    public void voteEdit(Vote vote) throws Exception {
        voteRepo.voteEdit(vote);
    }

    @Override
    public void voteVisitCount(int vno) throws Exception {
        voteRepo.voteVisitCount(vno);
    }

    @Override
    public void voteFinalInsert(VoteCountVo voteCount) throws Exception {
        voteRepo.voteFinalInsert(voteCount);
    }

    @Override
    public List<VoteList> voteAnswerList(int vno) throws Exception {
        return voteRepo.voteAnswerList(vno);
    }

    @Override
    public void voteAnswerInsert(VoteList voteList) throws Exception {
        voteRepo.voteAnswerInsert(voteList);
    }

    @Override
    public void voteAnswerDelete(int lno) throws Exception {
        voteRepo.voteAnswerDelete(lno);
    }

    @Override
    public void voteAllAnswerDelete(int vno) throws Exception {
        voteRepo.voteAllAnswerDelete(vno);
    }

    @Override
    public void voteAnswerEdit(VoteList voteList) throws Exception {
        voteRepo.voteAnswerEdit(voteList);
    }

    @Override
    public List<Vote> voteMyList(String sid) throws Exception {
        return voteRepo.voteMyList(sid);
    }

    @Override
    public VoteUser voteUserList(VoteUser voteUser) throws Exception {
        return voteRepo.voteUserList(voteUser);
    }

    @Override
    public int voteUserCnt(int lno) throws Exception {
        return voteRepo.voteUserCnt(lno);
    }

    @Override
    public void voteUserInsert(VoteUser voteUser) throws Exception {
        voteRepo.voteUserInsert(voteUser);
    }

    @Override
    public void voteUserDelete(VoteUser voteUser) throws Exception {
        voteRepo.voteUserDelete(voteUser);
    }

    @Override
    public List<VoteCountVo> voteCountList(int vno) throws Exception {
        return voteRepo.voteCountList(vno);
    }

    @Override
    public VoteCountVo voteMaxCountList(int vno) throws Exception {
        return voteRepo.voteMaxCountList(vno);
    }

    @Override
    public int voteCountCnt(int vno) throws Exception {
        return voteRepo.voteCountCnt(vno);
    }

}