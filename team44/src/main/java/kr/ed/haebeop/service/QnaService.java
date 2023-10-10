package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Qna;
import kr.ed.haebeop.util.Page;

import java.util.List;

public interface QnaService {

    // QnaBoard
    public List<Qna> qnaList(Page page) throws Exception;
    public Qna qnaGet(int qno) throws Exception;
    public int qnaCount(Page page) throws Exception;
    public void qnaInsert(Qna qna) throws Exception;
    public void qnaUpdate(Qna qna) throws Exception;
    public void qnaDelete(int qno) throws Exception;
    public List<Qna> qnaGetPar(int par) throws Exception;
}
