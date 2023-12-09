package com.itranswarp.scan.proxy;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itranswarp.summer.annotation.Component;
import com.itranswarp.summer.annotation.Order;
import com.itranswarp.summer.context.BeanPostProcessor;

@Order(100)
@Component
public class FirstProxyBeanPostProcessor implements BeanPostProcessor {

    final Logger logger = LoggerFactory.getLogger(getClass());

    Map<String, Object> originBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (OriginBean.class.isAssignableFrom(bean.getClass())) {
            // 18:09:24.072 [main] DEBUG c.i.s.p.FirstProxyBeanPostProcessor --
            // create first proxy for bean 'originBean': com.itranswarp.scan.proxy.OriginBean@33bc72d1
            logger.debug("create first proxy for bean '{}': {}", beanName, bean);
            var proxy = new FirstProxyBean((OriginBean) bean);
            // 存了一个 （originBean，OriginBean@33bc72d1）
            originBeans.put(beanName, bean);
            return proxy;
        }
        return bean;
    }

    @Override
    public Object postProcessOnSetProperty(Object bean, String beanName) {
        Object origin = originBeans.get(beanName);
        if (origin != null) {
            logger.debug("auto set property for {} from first proxy {} to origin bean: {}", beanName, bean, origin);
            return origin;
        }
        return bean;
    }
}
