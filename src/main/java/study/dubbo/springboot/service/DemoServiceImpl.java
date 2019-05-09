package study.dubbo.springboot.service;

import org.apache.dubbo.config.annotation.Service;
import study.dubbo.service.DemoService;

import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public void sayHi() {

    }

    @Override
    public Map<String, Object> sayHii() {
        return null;
    }

    @Override
    public void sayBye() {

    }
}
