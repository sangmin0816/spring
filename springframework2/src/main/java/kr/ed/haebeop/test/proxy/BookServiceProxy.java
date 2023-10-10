package kr.ed.haebeop.test.proxy;
public class BookServiceProxy implements BookService {
    //프록시는 BookServiceImpl과 같은 구현체를 가지고 있어야 함(delegate ->)
    private BookServiceImpl bookService;
    //BookServiceImpl(구현체)를 생성자로 주입
    public BookServiceProxy(BookServiceImpl bookService) {
        this.bookService = bookService;
    }
    // 프록시에서 주기능에 부가기능을 추가
    @Override
    public void rent(Book book) {
        System.out.println("트랜잭션 처리");  //  부가기능
        bookService.rent(book); // 프록시 -> 핵심기능
        System.out.println("로깅");   //부가기능
    }
}
//Aspects Oriented Programming = 관점 지향형 프로그래밍 : 여기 저기 다른 클래스에 흩어져 있는 메소드를 한 곳에 모아 적정한 시기가 되면, 처리될 수 있도록 한 모음판 역할을 하는 프로그래밍 기법
//자주 사용하거나 핵심적인 기능을 묶어 하나의 클래스로 선언한 후 사용하게 하는 방법