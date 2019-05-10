package study.dubbo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 入口
 *
 * @author wangzhj
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Startup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Startup.class, args);
        context.start();
    }
}

