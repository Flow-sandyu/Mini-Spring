package com.itranswarp.scan.aaa;

import com.itranswarp.scan.proxy.*;
import com.itranswarp.summer.annotation.ComponentScan;
import com.itranswarp.summer.annotation.Import;

@Import({OriginBean.class, FirstProxyBean.class, FirstProxyBeanPostProcessor.class,
SecondProxyBean.class, SecondProxyBeanPostProcessor.class})
// @ComponentScan
public class ScanApplication {

}
