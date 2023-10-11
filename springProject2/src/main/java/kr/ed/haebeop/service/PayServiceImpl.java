package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Pay;
import kr.ed.haebeop.persistence.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService{
    @Autowired
    private PayMapper payMapper;

    @Override
    public List<Pay> payAllList() throws Exception {
        return payMapper.payAllList();
    }

    @Override
    public List<Pay> payList(String memId) throws Exception {
        return payMapper.payList(memId);
    }

    @Override
    public Pay payGet(int payNo) throws Exception {
        return payMapper.payGet(payNo);
    }

    @Override
    public void payInsert(Pay pay) throws Exception {
        payMapper.payInsert(pay);
    }

    @Override
    public void payUpdate(Pay pay) throws Exception {
        payMapper.payUpdate(pay);
    }

    @Override
    public void payDelete(int payNo) throws Exception {
        payMapper.payDelete(payNo);
    }
}
