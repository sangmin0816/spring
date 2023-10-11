package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Qna;
import kr.ed.haebeop.persistence.QnaMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QnaServiceImpl implements QnaService{
    @Autowired
    private QnaMapper qnaRepo;
    // Qna
    @Override
    public List<Qna> qnaList(Page page) throws Exception {
        return qnaRepo.qnaList(page);
    }

    @Override
    public Qna qnaGet(int qno) throws Exception {
        return qnaRepo.qnaGet(qno);
    }

    @Override
    public int qnaCount(Page page) throws Exception {
        return qnaRepo.qnaCount(page);
    }

    @Override
    public void qnaInsert(Qna qna) throws Exception {
        qnaRepo.qnaInsert(qna);
    }

    @Override
    public void qnaUpdate(Qna qna) throws Exception {
        qnaRepo.qnaUpdate(qna);
    }

    @Override
    public void qnaDelete(int qno) throws Exception {
        Qna qna = qnaRepo.qnaGet(qno);
        if(qna.getLev()==0){
            List<Qna> qnaList = qnaGetPar(qna.getPar());
            for(Qna q: qnaList){
                qnaRepo.qnaDelete(q.getQno());
            }
        }
        qnaRepo.qnaDelete(qno);
    }

    @Override
    public List<Qna> qnaGetPar(int par) throws Exception {
        return qnaRepo.qnaGetPar(par);
    }
}
