import kr.co.teaspoon.dto.Sample;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// 에디터에서 module의 test 설정해주면 junit Test 가능
// servlet은 java로 시작하는 Logger import.

public class LombokTestLog {
    private static final Logger log = LoggerFactory.getLogger("LombokTestLog.class");
    // 현재 클래스 이름을 명시

    //모든 클래스의 테스트 전 사전작업
    @BeforeClass
    public static void beforeClassTest(){
        System.out.println("LombokTest 시작");
    }

    // 테스트 전에 사전작업
    @Before
    public void beforeTest(){
        System.out.println("Test 시작~");
    }


    @Test // 테스트할 때만 어노테이션 사용
    public void testLombok(){
        Sample dto = new Sample();
        dto.setNo(1);
        dto.setName("Kim1");
        log.info(dto.toString());
        System.out.println(dto.toString()); // 단위 테스트 후에 sout 가능.
    }

    // Test Annotaion이 안 붙어 있으면 실행되지 않음.
    @Test
    public void notest(){
        Sample dto = new Sample();
        dto.setNo(2);
        dto.setName("Kim2");
        System.out.println(dto.toString());
    }

    // Test 종료 후 실행. 한 테스트마다 실행된다.
    @After
    public void afterTest(){
        System.out.println("Test 끝~");
    }

    @AfterClass
    public static void afterClassTest(){
        System.out.println("LombokTest 끝");
    }
}
