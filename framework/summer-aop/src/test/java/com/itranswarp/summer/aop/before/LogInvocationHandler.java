package com.itranswarp.summer.aop.before;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itranswarp.summer.annotation.Component;
import com.itranswarp.summer.aop.BeforeInvocationHandlerAdapter;

@Component
public class LogInvocationHandler extends BeforeInvocationHandlerAdapter {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void before(Object proxy, Method method, Object[] args) {
        logger.info("[Before] {}()", method.getName());
    }
}

// @Component
// public class LogInvocationHandler implements InvocationHandler {
//
//     final Logger logger = LoggerFactory.getLogger(getClass());
//
//     public void before(Object proxy, Method method, Object[] args) {
//         logger.info("[Before] {}()", method.getName());
//     }
//
//     @Override
//     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//         before(proxy, method, args);
//         return method.invoke(proxy, args);
//     }
// }
