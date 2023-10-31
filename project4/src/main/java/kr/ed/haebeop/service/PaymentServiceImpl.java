package kr.ed.haebeop.service;


import kr.ed.haebeop.domain.Delivery;
import kr.ed.haebeop.domain.Payment;
import kr.ed.haebeop.persistence.DeliveryMapper;
import kr.ed.haebeop.persistence.PaymentMapper;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private DeliveryMapper deliveryMapper;

    @Override
    public List<Payment> paymentList_Member (String id) throws Exception {
        return paymentMapper.paymentList_Member(id);
    }

    @Override
    public List<Payment> paymentList_admin(Page page) throws Exception {
        return paymentMapper.paymentList_admin(page);
    }

    @Override
    public List<Payment> paymentList_mypage(Page page) throws Exception {
        return paymentMapper.paymentList_mypage(page);
    }

    @Override
    public int paymentCount(Page page) throws Exception {
        return paymentMapper.paymentCount(page);
    }

    @Transactional
    @Override
    public void insertpayment(Payment pay, Delivery delivery) throws Exception {
        paymentMapper.insertpayment(pay);
        int payNo = paymentMapper.paymentGetLast();
        delivery.setPayNo(payNo);
        deliveryMapper.deliveryInsert(delivery);
    }

    @Override
    public void deletepayment(int payno) throws Exception {
            paymentMapper.deletepayment(payno);
    }

    @Override
    public Payment paymentList_Lecture(int dno) throws Exception {
        return paymentMapper.paymentList_Lecture(dno);
    }

}
