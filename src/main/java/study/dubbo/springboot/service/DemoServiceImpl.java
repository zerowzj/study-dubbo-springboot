package study.dubbo.springboot.service;

import com.google.common.collect.Maps;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import study.dubbo.service.DemoService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/demo")
@Produces({MediaType.APPLICATION_JSON})
//@Component
@Service(interfaceName = "study.dubbo.service.DemoService", version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @GET
    @Path("/say_hi")
    public void sayHi() {
        LOGGER.info("hello...");
//        try {
//            TimeUnit.SECONDS.sleep(10 * 1000);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
        LOGGER.info("sayHi finish");
    }

    public void sayBye() {
//        AopContext.currentProxy();
        LOGGER.info("bye bye...");
    }

    @GET
    @Path("/say_hii")
    public Map<String, Object> sayHii() {
        Map<String, Object> data = Maps.newHashMap();
        data.put("name", "wangzhj");
        data.put("age", 36);
//        if ("".equals("")) {
//            throw new IllegalArgumentException("非法参数异常");
//        }
        return data;
    }
}
