package study.dubbo.springboot.service;

import com.google.common.collect.Maps;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import study.dubbo.service.DemoService;

import java.util.Map;

@Component
@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public void sayHi() {

    }

    @Override
    public Map<String, Object> sayHii() {
        Map<String, Object> data = Maps.newHashMap();
        data.put("code", "0");
        data.put("desc", "成功");
        LOGGER.info("SSSSSSSSSSSSSSSS");
        return data;
    }

    @Override
    public void sayBye() {

    }
}
