package cn.tbs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    private  Object target;

    public MyHandler() {
    }

    public MyHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强");
        Object invoke = method.invoke(target, args);
        System.out.println("后置增强");
        return invoke;
    }
}
