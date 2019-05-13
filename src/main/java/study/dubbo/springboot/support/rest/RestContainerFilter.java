package study.dubbo.springboot.support.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

/**
 * 如果在服务端进行过滤请求（比如认证）可以实现该接口。
 * 默认情况下，实现该接口的类
 * <p>
 * （1）实现类必须使用@Provider注解修饰，这样才会被JAX-Rs执行。(javax.ws.rs.ext.Provider)
 * （2）如果没有使用注解（javax.ws.rs.NameBinding），对于该实现类的实例，作用域是全局的
 * （3）如果实现类不使用@PreMatching注解，将在请求到资源（该处资源指的是被@Get、@Post、@Put…修饰的方法）之后执行
 * （4）如果实现类使用@PreMatching注解，将在请求到资源之前执行
 */
//@Activate
//@Provider
//@PreMatching
public class RestContainerFilter implements ContainerRequestFilter,
        ContainerResponseFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestContainerFilter.class);

    @Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;

    @Override
    public void filter(ContainerRequestContext requestCxt) throws IOException {
        LOGGER.info("request filter", request.getRequestURI());
//        HttpServletRequest request = (HttpServletRequest) cxt.getRequest();
//        // 编码处理

//
//        cxt.setProperty(InputPart.DEFAULT_CHARSET_PROPERTY, ENCODING_UTF_8);

        // 客户端head显示提醒不要对返回值进行封装
//        cxt.setProperty("Not-Wrap-Result", cxt.getHeaderString("Not-Wrap-Result") == null ? "" : requestContext.getHeaderString("Not-Wrap-Result"));
        try {
            //编码处理
//            request.setCharacterEncoding(ENCODING_UTF_8);
//            request.setAttribute(InputPart.DEFAULT_CHARSET_PROPERTY, ENCODING_UTF_8);
//
//            response.setCharacterEncoding(ENCODING_UTF_8);
        } finally {

        }
    }

    @Override
    public void filter(ContainerRequestContext requestCxt, ContainerResponseContext responseCxt) throws IOException {
        LOGGER.info("response filter");
        try {

        } finally {

        }
    }
}
