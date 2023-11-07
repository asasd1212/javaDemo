package cn.tbs.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class TransactionManagerAdvice {
    public void before() {
        System.out.println("前置增强.........");
    }
    // 后置增强
    public void afterReturning(){
        System.out.println("后置通知...");
    }

    // 异常增强
    public void afterThrowing(){
        System.out.println("异常通知...");
    }

    // 最终增强
    public void after(){
        System.out.println("最终通知...");
    }

    public void around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("前置增强11111");
            Object proceed = joinPoint.proceed();
            System.out.println("后置增强");
        } catch (Throwable throwable) {
            // 做异常通知
            System.out.println("异常通知..........");

        } finally {
            System.out.println("最终增强");
        }


    }
}
