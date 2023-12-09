package com.itranswarp.scan.proxy;

import com.itranswarp.summer.annotation.Autowired;
import com.itranswarp.summer.annotation.Component;

@Component
public class InjectProxyOnPropertyBean {

    // 需要依赖与原始 bean，即 InjectProxyOnPropertyBean，但 InjectProxyOnPropertyBean 也有被代理
    @Autowired
    public OriginBean injected;
}
