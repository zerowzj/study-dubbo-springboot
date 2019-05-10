package study.dubbo.springboot.support.config;

import org.apache.dubbo.remoting.http.servlet.DispatcherServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DispatcherServletCfg {

    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServletCfg.class);

    @Bean
    public ServletRegistrationBean backServlet() {
        LOGGER.info("********************");
        LOGGER.info("DispatcherServletCfg");
        LOGGER.info("********************");

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(dispatcherServlet);
        registrationBean.setUrlMappings(Arrays.asList("/*"));
        registrationBean.setLoadOnStartup(1);

        return registrationBean;
    }
}
