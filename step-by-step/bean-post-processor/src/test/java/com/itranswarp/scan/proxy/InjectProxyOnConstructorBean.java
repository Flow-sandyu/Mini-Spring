package com.itranswarp.scan.proxy;

import com.itranswarp.summer.annotation.Autowired;
import com.itranswarp.summer.annotation.Component;

@Component
public class InjectProxyOnConstructorBean {

    public final OriginBean injected;

    // 需要注入 OriginBean 的代理 bean
    public InjectProxyOnConstructorBean(@Autowired OriginBean injected) {
        this.injected = injected;
    }
}
