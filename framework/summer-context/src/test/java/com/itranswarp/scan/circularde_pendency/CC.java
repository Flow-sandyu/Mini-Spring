package com.itranswarp.scan.circularde_pendency;

import com.itranswarp.summer.annotation.Autowired;
import com.itranswarp.summer.annotation.Component;

@Component
public class CC {

    BB bb;
    public CC(@Autowired BB bb) {
        this.bb = bb;
    }
}
