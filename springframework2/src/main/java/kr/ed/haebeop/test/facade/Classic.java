package kr.ed.haebeop.test.facade;

class Rinsing {
    void rinse(){
        System.out.println("린스 적용");
    }
}
class Spinning{
    void spin(){
        System.out.println("스핀 적용");
    }
}
class Washing {
    void wash(){
        System.out.println("헹구기");
    }
}
public class Classic {
    public static void main(String[] args) {
        Washing washing = new Washing();
        Rinsing rinsing = new Rinsing();
        Spinning spinning = new Spinning();

        washing.wash();
        rinsing.rinse();
        spinning.spin();
    }
}
