package com.example.rout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "RouteExchange",type = "direct"),
                    key = {"info"}
            )
    }
    )
    public void  receviel1(String message){
        System.out.println("这里是info队列拿到的信息："+message);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "RouteExchange",type = "direct"),
                    key = {"error"}
            )
    }
    )
    public void  receviel2(String message){
        System.out.println("这里是error队列拿到的信息："+message);
    }
}
