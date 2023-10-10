package kr.ed.haebeop.test.singleton;


public class SingletonService {
    //기본 생성자로 만들지 않고, static 키워드와 final 키워드를 사용

    //SingletonService single = new SingletonService()를 외부에서 객체 생성 불가하도록
    // private으로 설정하고, final, static 이므로 변경할 수 없음.
    private static final SingletonService instance = new SingletonService();

    //static : 생성자로 만들지 않고, 해당 클래스를 그대로 사용하여 객체 생성
    //외부에서 생성할 수 있는 getInstance()를 선언하여 현재 클래스 내부에서 객체를 만들어
    //반환하되 static으로 설정 되어 있으므로 정적으로 잡혀 있기 때문에 객체를 많이 만들어도
    //오로지 같은 객체만 만들므로 주로 공유 데이터나 메모리, 입구를 하나만 두는 서비스에서
    //활용된다.
    public static SingletonService getInstance(){ //객체 생성 메소드
        return instance;
    }
    //생성자 함수도 private으로 설정
    private SingletonService() { }
}
