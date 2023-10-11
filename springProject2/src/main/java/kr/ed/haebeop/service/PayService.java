package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Pay;

import java.util.List;

public interface PayService {
    public List<Pay> payAllList() throws Exception;
    public List<Pay> payList(String memId) throws Exception;
    public Pay payGet(int payNo) throws Exception;
    public void payInsert(Pay pay) throws Exception;
    public void payUpdate(Pay pay) throws Exception;
    public void payDelete(int payNo) throws Exception;
}
