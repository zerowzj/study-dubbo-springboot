package study.dubbo.springboot.support.dubbo;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.RpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Activate(group = Constants.PROVIDER, order = 1)
public class WatchDogFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatchDogFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker,
                         Invocation invocation) throws RpcException {
        LOGGER.info("i am watch dog");
        Stopwatch watch = Stopwatch.createStarted();
        //
        String canonicalName = invoker.getInterface().getCanonicalName();
        String methodName = invocation.getMethodName();
        String fullMethod = Joiner.on(".").join(canonicalName, methodName);
        URL url = invoker.getUrl();
        LOGGER.info("url={}", url);
        //
        Result result;
        try {
            result = invoker.invoke(invocation);
            //异常
            LOGGER.info("has_exception= {}", result.hasException());
            //返回值
            Object value = result.getValue();
//            LOGGER.info("value class= {}", value.getClass().getSimpleName());
            //
            if (result.hasException()) {
                Map<String, Object> data = Maps.newHashMap();
                data.put("code", "9999");
                data.put("desc", result.getException().getMessage());
                RpcResult rpcResult = (RpcResult) result;
                //调用端不抛异常
                rpcResult.setException(null);
                rpcResult.setValue(data);
                return rpcResult;
            }
        } catch (RpcException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            LOGGER.info("[{}] [COST TIME {}ms]", fullMethod, watch.elapsed(TimeUnit.MILLISECONDS));
        }
        return result;
    }
}
