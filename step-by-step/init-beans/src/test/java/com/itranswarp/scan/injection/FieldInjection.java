package com.itranswarp.scan.injection;

import com.itranswarp.summer.annotation.Component;
import com.itranswarp.summer.annotation.Value;

import jakarta.annotation.PostConstruct;

@Component
public class FieldInjection {

    @Value("${app.title}")
    String appTitle;

    @Value("${app.version}")
    String appVersion;

    public String appName;

    @PostConstruct
    void init() {
        this.appName = this.appTitle + " / " + this.appVersion;
    }
}
