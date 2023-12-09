package com.itranswarp.scan.proxy;

import com.itranswarp.summer.annotation.Component;
import com.itranswarp.summer.annotation.Value;

@Component
public class OriginBean {

    @Value("${app.title}")
    public String name;

    public String version;

    public String appName;

    // 需要依赖与原始 bean，即 OriginBean
    @Value("${app.version}")
    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return this.version;
    }

    void init() {
        this.appName = this.name + " / " + this.version;
    }
}
