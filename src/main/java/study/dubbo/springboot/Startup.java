package study.dubbo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Startup {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Startup.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}

