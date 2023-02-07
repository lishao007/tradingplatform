//package com.example.tradingplatform.config;
//
//import com.example.tradingplatform.filter.UserFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class UserFilterConfig {
//    @Bean
//    public UserFilter userFilter(){
//        return new UserFilter();
//    }
//
//    @Bean(name = "userFilterConf")
//    public FilterRegistrationBean userFilterConfig(){userFilterConfig
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(userFilter());
//        filterRegistrationBean.addUrlPatterns("/shop/*");
//        filterRegistrationBean.addUrlPatterns("/order/*");
//        filterRegistrationBean.setName("userFilterConfig");
//        return filterRegistrationBean;
//    }
//}
