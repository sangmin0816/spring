package kr.ed.haebeop.test.facade;
//퍼사드 패턴 : 일률적인 일을 하나의 입구를 만들어 모두 퍼사드 클래스를 통해 
//자원을 접근하도록 하는 클래스
public class FacadeEx {
    public static void main(String[] args) {
        FacadeClass facade = new FacadeClass();
        facade.startWashing();
    }
}
