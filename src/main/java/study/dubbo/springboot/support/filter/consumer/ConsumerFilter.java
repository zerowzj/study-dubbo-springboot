package study.dubbo.springboot.support.filter.consumer;


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
 * 消费者过滤器
 *
 * @author wangzhj
 */
@Activate(group = Constants.CONSUMER)
public class ConsumerFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (RpcException ex) {
            ex.printStackTrace();
        } finally {
            LOGGER.info("i am consumer filter");
        }
        return result;
    }
}
