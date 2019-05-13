package study.dubbo.springboot.support.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

//@Configuration
public class ListenerCfg {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListenerCfg.class);

    @Bean
    public ServletListenerRegistrationBean dispatcherServlet() {
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        return registrationBean;
    }
}
