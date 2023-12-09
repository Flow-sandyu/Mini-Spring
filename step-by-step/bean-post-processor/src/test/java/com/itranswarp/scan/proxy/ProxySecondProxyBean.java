package com.itranswarp.scan.proxy;

public class ProxySecondProxyBean extends SecondProxyBean {

    OriginBean target;

    public ProxySecondProxyBean(OriginBean target) {
        super(target);
    }

    @Override
    public void setVersion(String version) {
        target.setVersion(version);
    }

    @Override
    public String getName() {
        return target.getName();
    }

    @Override
    public String getVersion() {
        return target.getVersion();
    }
}
