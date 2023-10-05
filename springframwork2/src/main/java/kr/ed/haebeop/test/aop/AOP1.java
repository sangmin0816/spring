package kr.ed.haebeop.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AOP1 {

    //kr.ed.haebeop.test.aop 패키지 하위에 있는 메소드가 실행되기 전에
    //@Before 어노테이션이 선언되어 있으면, 먼저 실행되고,
    //포인트컷이 정상 실행되어 리턴되면 @AfterReturning 어노테이션이 선언된 부분이 실행됨
    
    //kr.ed.haebeop.test.aop 패키지의 하위 메소드를 모두 포인트컷으로 설정함
    @Pointcut("execution(* kr.ed.haebeop.test.aop..*.*(..))")
    private void cut() {
        System.out.println("AOP 실습1");
    }

    @Pointcut("@annotation(kr.ed.haebeop.test.aop.Timer)")
    private void enableTimer() {
        System.out.println("AOP 실습2");
    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("--------------- @Before ---------------");
        System.out.println(joinPoint.toString());
        System.out.println(joinPoint.toShortString());
        System.out.println(joinPoint.toLongString());
    }

    @AfterReturning(value = "cut()", returning = "object")
    public void afterReturn(JoinPoint joinPoint, Object object) {
        System.out.println("--------------- @After ---------------");
        System.out.println(object);
    }

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--------------- @Around ---------------");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 타겟 오브젝트의 메서드 실행(controller 패키지 하위 클래스들의 메소드)
        Object result = joinPoint.proceed();
        System.out.println("result: " + result);
        stopWatch.stop();
        System.out.println("Total Time: " + stopWatch.getTotalTimeSeconds());
    }
}

/*
어노테이션 설명
@Aspect : 해당 클래스가 Aspect를 나타내는 클래스임을 명시하는 어노테이션
@Component : 스프링 빈으로 등록하기 위한 어노테이션
@Pointcut : 포인트컷 표현식을 나타내는 어노테이션으로 부가 기능이 적용될 대상을 지정
@Before : 타겟 메소드가 실행하기 이전 어드바이스 기능을 수행
@After : 타겟 메소드의 결과에 상관없이 실행 후 어드바이스 기능을 수행
@AfterReturning : 타겟 메소드가 정상적으로 결과값을 반환 후 어드바이스 기능을 수행
@AfterThrowing : 타겟 메소드가 수행 중 예외를 발생하면 어드바이스 기능을 수행
@Around : 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출전, 후 어드바이스 기능을 수행
 */

/*
포인트컷 표현식 샘플
execution(int method1(int, int)) : int 타입의 리턴 값, method1 이라는 메소드, 두 개의 int 파라미터를 가지는 메소드를 허용하는 포인트컷 표현식
execution(* method2(String, int)): 모든 타입의 리턴, method2 이라는 메소드, 두 개의 String, int 파라미터를 가지는 메소드를 허용하는 포인트컷 표현식
execution(* method3()): 리턴 타입은 상관없이 파라미터가 존재하지 않는 method3 메소드가 구현될 때 실행을 허용하는 포인트컷 표현식
execution(* method4(..)): 모든 타입의 리턴, 파라미터는 타입의 종류나 개수에 상관없이 method4 라는 메소드 이름을 가진 모든 메소드가 구현될 때 실행할 포인트컷 표현식
execution(* *(..)): 리턴 타입, 파라미터, 메소드 이름에 상관없이 모든 조건을 허용하는 포인트컷 표현식
execution(* kr.ed.haebeop.aop.Test.*(..)): kr.ed.haebeop.aop 패키지의 Test 클래스에 존재하는 메소드가 구현될 때 실행할 포인트컷 표현식
execution(* kr.ed.haebeop.aop.*.*(..)): kr.ed.haebeop.aop 패키지에 존재하는 모든 클래스의 메소드가 구현될 때 실행할 포인트컷 표현식
 */

/*
용어 설명
타겟(Target) : 부가기능을 부여할 대상을 의미합니다.
애스펙트(Aspect) : AOP가 정의되는 클래스로서 부가기능을 정의한 어드바이스와 어드바이스를 어디에 적용할지 결정하는 포인트컷의 조합이며, 보통 싱글톤 형태의 오브젝트로 존재합니다.
어드바이스(Advice) : 실질적으로 부가기능을 담은 구현체로서 어드바이스의 경우 타겟 오브젝트에 종속되지 않기 때문에 순수하게 부가기능에만 집중할 수 있습니다.
조인포인트(Join Point) : 어드바이스가 적용될 수 있는 위치를 지정하는 메소드
포인트컷(PointCut) : 부가기능이 적용될 대상
프록시(Proxy) : 클라이언트와 타겟 사이에 투명하게 존재하여 부가기능을 제공하는 오브젝트로서 DI를 통해 타겟 대신 클라이언트에게 주입되며, 클라이언트의 메소드 호출을 대신 받아 타겟에 위임해주며 부가기능을 부여합니다.
인트로덕션(Introduction) : 타겟 클래스에 추가적인 메소드나 필드를 추가하는 기능을 의미합니다.
위빙(Weaving) : 어드바이스를 핵심 로직 코드에 적용하는 것을 의미합니다.
 */