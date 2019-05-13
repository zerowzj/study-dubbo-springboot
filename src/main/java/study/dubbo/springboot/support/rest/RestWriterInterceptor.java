package study.dubbo.springboot.support.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

public class RestWriterInterceptor implements WriterInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestWriterInterceptor.class);

    @Override
    public void aroundWriteTo(WriterInterceptorContext cxt) throws IOException, WebApplicationException {
        LOGGER.info("909090900000000000000000");
        cxt.proceed();
    }
}
