package com.itranswarp.summer.aop.around;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.itranswarp.summer.context.AnnotationConfigApplicationContext;
import com.itranswarp.summer.io.PropertyResolver;

public class AroundProxyTest {

    @Test
    public void testAroundProxy() {
        try (var ctx = new AnnotationConfigApplicationContext(AroundApplication.class, createPropertyResolver())) {
            // 这个 bean 已经被 AnnotationProxyBeanPostProcessor 代理为增强过代码的 代理bean
            // aop nb在加一个注解和增强代码，就可以实现增强，具体增强的实现都由 spring 做好了
            OriginBean proxy = ctx.getBean(OriginBean.class);
            // OriginBean$ByteBuddy$8NoD1FcQ
            System.out.println(proxy.getClass().getName());

            // proxy class, not origin class:
            assertNotSame(OriginBean.class, proxy.getClass());
            // proxy.name not injected:
            assertNull(proxy.name);

            assertEquals("Hello, Bob!", proxy.hello());
            assertEquals("Morning, Bob.", proxy.morning());

            // test injected proxy:
            OtherBean other = ctx.getBean(OtherBean.class);
            assertSame(proxy, other.origin);
            assertEquals("Hello, Bob!", other.origin.hello());
        }
    }

    PropertyResolver createPropertyResolver() {
        var ps = new Properties();
        ps.put("customer.name", "Bob");
        var pr = new PropertyResolver(ps);
        return pr;
    }
}
