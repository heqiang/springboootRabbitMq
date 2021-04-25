package com.example.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
//                     value = @Queue, // 临时队列
                    value = @Queue("fanout2"),
                    exchange = @Exchange(value = "logs",type = "fanout")
            )
    })
    public  void  receviel1(String message){
        System.out.println("消费者1："+message);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
//                     value = @Queue, // 临时队列
                    value = @Queue("fanout1"),
                    exchange = @Exchange(value = "logs",type = "fanout")
            )
    })
    public  void  receviel2(String message){
        System.out.println("消费者2："+message);
    }
}
