package cn.tbs.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionManagerAdvice2 {
    @Pointcut("execution(* cn.cn.tbs.service..*.*(..))")
    public void pointcut(){

    }
//    @Before("pointcut()")
//    public void before() {
//        System.out.println("前置增强.........");
//    }
//    // 后置增强
//    @AfterReturning(pointcut = "pointcut()",returning = "result")
//    public void afterReturning(Object result){
//        System.out.println("后置通知..."+result);
//    }
//    //    异常
//    @AfterThrowing(pointcut = "pointcut()",throwing = "e")
//    public void afterThrowing(Throwable e){
//
//        System.out.println("异常通知"+e.getMessage());
//    }
//    //  最终
//    @After("pointcut()")
//    public void after(){
//        System.out.println("最终");
//    }

    @Around("pointcut()")
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
