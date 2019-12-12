package org.sc;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;


/**
 *  command
 *   export NAMESRV_ADDR=localhost:9876
 *   sh bin/tools.sh org.apache.rocketmq.example.quickstart.Producer
 *   sh bin/tools.sh org.apache.rocketmq.example.quickstart.Consumer
 *
 *   nohup sh bin/mqnamesrv &
 *
 *   nohup sh bin/mqbroker -n localhost:9876 &   autoCreateTopicEnable=true
 */
public class AsyncProducer {
    public static final String host = "10.0.100.235:9876";
    public static final String host1 = "10.0.100.235:10911";
    public static final String host2 = "localhost:10911";

    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new DefaultMQProducer("1057Sc");
        // Specify name server addresses.
        producer.setNamesrvAddr(host);
        //Launch the instance.
        producer.start();
        // producer.setVipChannelEnabled(true);
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest",
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
