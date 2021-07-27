package dev.temnikov.onlineshop.config;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import javax.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {
    @Bean
    public Filter TracingFilter() {
        return new AWSXRayServletFilter("onlineShop");
    }
}
