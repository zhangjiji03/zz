package com.zz.common.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：quboka
 * @description：Id生成
 * @date ：2020/1/7 20:10
 */
@Configuration
public class IdGenerateConfig {

    /**
     * 雪花算法
     *  snowFlakeGenerator.nextId();
     */
    @Bean
    public SnowFlakeGenerator snowFlakeGenerator(){
        return new SnowFlakeGenerator.Factory().create(0,0);
    }
}
