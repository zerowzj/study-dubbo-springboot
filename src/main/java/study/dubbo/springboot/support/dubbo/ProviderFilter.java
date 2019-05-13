package study.dubbo.springboot.support.dubbo;


import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 提供者过滤器
 *
 * @author wangzhj
 */
@Activate(group = Constants.PROVIDER, order = 2)
public class ProviderFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker,
                         Invocation invocation) throws RpcException {
        LOGGER.info("i am provider filter");

        invoker.getInterface().getCanonicalName();

        invocation.getMethodName();
        invocation.getArguments();

        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (RpcException ex) {
//            ex.printStackTrace();
        } finally {
        }
        return result;
    }
}
