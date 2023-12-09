package com.itranswarp.scan;

import com.itranswarp.summer.annotation.Autowired;
import com.itranswarp.summer.annotation.Bean;
import com.itranswarp.summer.annotation.Configuration;

@Configuration
public class AA {
    @Bean
    BB add (@Autowired BB bb) {
        return bb;
    }

}
