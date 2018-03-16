package com.hoo.framework.hystrix.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by ravihoo on 10/03/2018.
 */
@Configuration
@PropertySource("classpath:application.yml")
public class HystrixConfiguration {

    private static final String HYSTRIX_STREAM = "/hystrix.stream";

    /**
     * to expose stream endpoint
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), HYSTRIX_STREAM);
    }

}
