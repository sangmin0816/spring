package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Delivery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    @Select("select * from delivery")
    public List<Delivery> deliveryList();
    
    @Select("select * from delivery where dno = #{dno}")
    public Delivery deliveryGet(int dno);
    
    @Insert("INSERT INTO delivery(pay_no, memId, name, tel, address, dcom, dtel, state, eta, dcode, dno) VALUES(#{pay_no}, #{memId}, #{name}, #{tel}, #{address}, #{dcom}, #{dtel}, #{state}, #{eta}, #{dcode}, #{dno})")
    public void deliveryInsert(Delivery delivery);
    
    @Update("update delivery set pay_no=#{pay_no}, memId=#{memId}, name=#{name},  tel=#{tel}, address=#{address}, dcom=#{dcom}, dtel=#{dtel}, state=#{state}, eta=#{eta}, dcode=#{dcode} where dno=#{dno}")
    public void deliveryUpdate(Delivery delivery);

    @Delete("DELETE FROM delivery where dno=#{dno}")
    public void deliveryDelete(int dno);
}
