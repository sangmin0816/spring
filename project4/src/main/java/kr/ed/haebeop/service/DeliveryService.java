package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Delivery;

import java.util.List;

public interface DeliveryService {
    public List<Delivery> deliveryList();
    public Delivery deliveryGet(int dno);
    public void deliveryInsert(Delivery delivery);
    public void deliveryUpdate(Delivery delivery);
    public void deliveryDelete(int dno);
}
