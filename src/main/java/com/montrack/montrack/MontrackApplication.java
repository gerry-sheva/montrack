package com.montrack.montrack;

import com.montrack.montrack.config.RsaKeyConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyConfigProperties.class)
@SpringBootApplication
public class MontrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MontrackApplication.class, args);
    }

}
