package kr.ed.haebeop.test.facade;

public class FacadeClass {
    Washing washing = new Washing();
    Rinsing rinsing = new Rinsing();
    Spinning spinning = new Spinning();

    public void startWashing(){
        rinsing.rinse();
        spinning.spin();
        washing.wash();
    }
}
