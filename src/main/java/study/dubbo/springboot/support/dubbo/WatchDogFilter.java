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

/**
 * 看门狗过滤器
 *
 * @author wangzhj
 */
@Activate(group = Constants.PROVIDER, order = 1)
public class WatchDogFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatchDogFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker,
                         Invocation invocation) throws RpcException {
        //
        LOGGER.info("i am watch dog");
        Stopwatch watch = Stopwatch.createStarted();
        //
        String canonicalName = invoker.getInterface().getCanonicalName();
        String methodName = invocation.getMethodName();
        String fullMethod = Joiner.on(".").join(canonicalName, methodName);
        URL url = invoker.getUrl();
        LOGGER.info("url={}", url);
        //
        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (Exception ex) {
//            ex.printStackTrace();
            Map<String, Object> data = Maps.newHashMap();
            data.put("code", "9999");
            data.put("desc", "异常");
            ((RpcResult) result).setValue(data);
//            return result;
//            throw ex;
        } finally {
            LOGGER.info("[{}] [COST TIME {}ms]", fullMethod, watch.elapsed(TimeUnit.MILLISECONDS));
        }
        return result;
    }
}
