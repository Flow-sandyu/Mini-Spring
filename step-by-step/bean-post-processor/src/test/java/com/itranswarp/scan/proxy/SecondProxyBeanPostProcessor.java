package com.itranswarp.scan.proxy;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itranswarp.summer.annotation.Component;
import com.itranswarp.summer.annotation.Order;
import com.itranswarp.summer.context.BeanPostProcessor;

@Order(200)
@Component
public class SecondProxyBeanPostProcessor implements BeanPostProcessor {

    final Logger logger = LoggerFactory.getLogger(getClass());

    Map<String, Object> originBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (OriginBean.class.isAssignableFrom(bean.getClass())) {
            // 我猜打印的是 bean 是 FirstProxyBean ，但 beanName 不确定，结果是 originBean
            // 打印结果 create second proxy for bean 'originBean': com.itranswarp.scan.proxy.FirstProxyBean@1a75e76a
            logger.debug("SecondProxyBeanPostProcessor‘s postProcessBeforeInitialization | create second proxy for bean '{}': {}", beanName, bean);
            var proxy = new SecondProxyBean((OriginBean) bean);
            // 存了一个 （originBean，FirstProxyBean@1a75e76a）
            originBeans.put(beanName, bean);
            return proxy;
        }
        return bean;
    }

    @Override
    public Object postProcessOnSetProperty(Object bean, String beanName) {
        Object origin = originBeans.get(beanName);
        if (origin != null) {
            // 猜测 beanName 是 originBean , bean 是 SecondProxyBeanxxx
            logger.debug("验证bean auto set property for {} from second proxy {} to origin bean: {}", beanName, bean, origin);
            return origin;
        }
        return bean;
    }
}
