package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Qna;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {
    public List<Qna> qnaList(Page page);
    public Qna qnaGet(int qno);
    public int qnaCount(Page page);
    public void qnaInsert(Qna qna);
    public void qnaUpdate(Qna qna);
    public void qnaDelete(int qno);
    public List<Qna> qnaGetPar(int par);
}
