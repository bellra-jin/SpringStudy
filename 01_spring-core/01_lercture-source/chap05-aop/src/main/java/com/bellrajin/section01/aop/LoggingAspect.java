package com.bellrajin.section01.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // @Pointcut : 여러 조인포인트를 매치하기 위해 지정한 표현식
    // execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
    // 수식어 생략 가능 (private, public, protected, default)
    @Pointcut("execution(* com.bellrajin.section01.aop.*Service.*(..))")
    public void logPointcut() {}


    // retrun 타입을 void로 작성해줘야 함
    // 어드바이스 정의
    // joinpoint가 동작하기 이전의 동작을 작성
    @Before("logPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("After joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }


}
