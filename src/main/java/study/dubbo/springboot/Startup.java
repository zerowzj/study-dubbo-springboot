package study.dubbo.springboot;

import org.apache.dubbo.remoting.http.servlet.DispatcherServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * 入口
 *
 * @author wangzhj
 */
@SpringBootApplication
public class Startup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Startup.class, args);
        context.start();
    }

//    @Bean
//    public ServletRegistrationBean backServlet() {
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
//        registrationBean.setServlet(dispatcherServlet);
//        registrationBean.setUrlMappings(Arrays.asList("/api/*"));
//        registrationBean.setLoadOnStartup(1);
//
//        return registrationBean;
//    }
}

