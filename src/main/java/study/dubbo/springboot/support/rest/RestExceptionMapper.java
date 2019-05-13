package study.dubbo.springboot.support.rest;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Map;

public class RestExceptionMapper implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionMapper.class);

    @Override
    public Response toResponse(Exception ex) {
        ex.printStackTrace();
        LOGGER.info("exception11111111111111111111111111");
        Map<String, Object> data = Maps.newHashMap();
        data.put("code", "9999");
        data.put("desc", "系统异常");
        return Response.status(200)
                .entity("sssssssssssssssssss")
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
