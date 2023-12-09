package com.itranswarp.scan.injection;

import com.itranswarp.summer.annotation.Autowired;
import com.itranswarp.summer.annotation.Component;
import com.itranswarp.summer.annotation.Value;
import jakarta.annotation.PostConstruct;

@Component
public class SetterInjection {
    String appTitle;

    String appVersion;


    FieldInjection fieldInjection;

    @Autowired(name = "fieldInjection")
    public void setFieldInjection(FieldInjection fieldInjection) {
        this.fieldInjection = fieldInjection;
    }
    public FieldInjection getFieldInjection() {
        return fieldInjection;
    }


    public String appName;

    @Value("${app.title}")
    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    @Value("${app.version}")
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public String getAppVersion() {
        return appVersion;
    }

    @PostConstruct
    void init() {
        this.appName = this.appTitle + " / " + this.appVersion;
    }
}
