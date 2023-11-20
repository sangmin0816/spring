package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Payment;
import kr.ed.haebeop.util.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    public List<Payment> paymentList_Member(String id) throws Exception;
    public Payment paymentList_Lecture(int dno) throws Exception;
    public List<Payment> paymentList_admin(Page page) throws Exception;
    public List<Payment> paymentList_mypage(Page page) throws Exception;
    public int paymentCount(Page page) throws Exception;
    public int insertpayment(Payment pay) throws Exception;
    public void deletepayment(int payno) throws Exception;
    public int paymentGetLast();

}