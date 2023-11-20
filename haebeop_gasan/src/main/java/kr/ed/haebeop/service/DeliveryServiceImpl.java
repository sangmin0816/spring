package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Delivery;
import kr.ed.haebeop.persistence.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService{
    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public List<Delivery> deliveryList() {
        return deliveryMapper.deliveryList();
    }

    @Override
    public Delivery deliveryGet(int dno) {
        return deliveryMapper.deliveryGet(dno);
    }

    @Override
    public void deliveryInsert(Delivery delivery) {
        deliveryMapper.deliveryInsert(delivery);
    }

    @Override
    public void deliveryUpdate(Delivery delivery) {
        deliveryMapper.deliveryUpdate(delivery);
    }

    @Override
    public void deliveryDelete(int dno) {
        deliveryMapper.deliveryDelete(dno);
    }
}
