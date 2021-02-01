package com.syj.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DebugInvocationHandler implements InvocationHandler {
    private final Object object;

    public DebugInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        Object result = null;
        switch (method.getName()) {
            case "send":
                System.out.println("before method " + method.getName());
                result = method.invoke(this.object, args);
                //调用方法之后，我们同样可以添加自己的操作
                System.out.println("after method " + method.getName());
                break;
            case "get":
                break;
            default:
                break;
        }
        return result;
    }
}
