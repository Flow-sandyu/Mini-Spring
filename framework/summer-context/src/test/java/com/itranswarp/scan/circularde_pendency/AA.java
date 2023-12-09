package com.itranswarp.scan.circularde_pendency;

import com.itranswarp.summer.annotation.Autowired;
import com.itranswarp.summer.annotation.Bean;
import com.itranswarp.summer.annotation.Configuration;

@Configuration
public class AA {

    @Bean
    CC add(@Autowired BB bb) {
        return new CC(bb);
    }
}
