package study.dubbo.springboot.support.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class FilterCfg {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListenerCfg.class);

    @Bean
    public FilterRegistrationBean dispatcherServlet() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        return registrationBean;
    }
}
