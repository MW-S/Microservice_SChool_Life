package net.mw.springcloud;

import net.mw.springcloud.config.jwt.JwtAuthenticationTokenFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("net.mw.springcloud.dao")
public class ProviderTrafficApplication {
    public static void  main(String[] args){
        SpringApplication.run( ProviderTrafficApplication.class, args);
    }

/*    @Bean
    public FilterRegistrationBean registration(JwtAuthenticationTokenFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }*/
}
