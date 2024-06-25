package com.bellrajin.section01.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  @Aspect => 기본적으로 기능 추가x => mavenrepository에 aspectj 검색 => aspectjweaver, aspectjruntime 추가
 *
 *  Advice 5가지 호출 방법을 배움
 */
@Aspect
@Component
public class LoggingAspect {
    // @Pointcut : 여러 조인포인트를 매치하기 위해 지정한 표현식
    // execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
    // 수식어(접근자) 생략가능. [ ] => 생략 가능을 뜻함
    // 맨 앞에 "*" => 모든 것 포함(리턴타입)
    // *Service => Service로 끝나는 클래스
    @Pointcut("execution(* com.bellrajin.section01.aop.*Service.*(..))")
    public void logPointcut() {}

    @Before("logPointcut()") // () 안에 위치 지정 => @Pointcut 메서드의 이름
    public void logBefore(JoinPoint joinPoint) { // @Before: 반환타입이 void여야 함

        System.out.println("Before joinPoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature(): " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0]: " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint){

        System.out.println("After joinPoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature(): " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0]: " + joinPoint.getArgs()[0]);
        }
    }

    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) { // returning의 이름과 매개변수의 이름이 같아야함(result)
        // result값 확인
        System.out.println("AfterReturning result : " + result);

        if(result != null && result instanceof Map) {
            ( (Map<Long, MemberDTO> ) result).put(100L, new MemberDTO(100L, "반환값 가공"));
        }
    }

    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfter(JoinPoint joinPoint, Exception exception) { // throwing 이름이 서로 같아야 함

        System.out.println("afterThrowing exception: " + exception);
    }

    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 사전
        System.out.println("Around Before : " + joinPoint.getSignature().getName());

        // 원본 조인 포인트를 실행한다.
        Object result = joinPoint.proceed();

        // 사후
        System.out.println("Around After : " + joinPoint.getSignature().getName());

        return result;
    }

}
