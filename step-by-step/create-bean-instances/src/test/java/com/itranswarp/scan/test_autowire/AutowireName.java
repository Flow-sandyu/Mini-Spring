package com.itranswarp.scan.test_autowire;

import com.itranswarp.summer.annotation.Autowired;
import com.itranswarp.summer.annotation.Component;

@Component
public class AutowireName {
    Car car1;

    public Car getCar1() {
        return car1;
    }

    public void setCar1(Car car1) {
        this.car1 = car1;
    }

    public AutowireName(@Autowired(name = "baoMa") Car car) {
        car1 = car;
    }
}
