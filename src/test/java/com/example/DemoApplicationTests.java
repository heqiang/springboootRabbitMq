package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
class DemoApplicationTests {

   // 注入rabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public  void  testHelloWorld(){
        rabbitTemplate.convertAndSend("hello","这是springbooot的");
    }
//  WorkQuquq 公平消费
    @Test
    public  void  testWorkQuqeue(){
        for (int i = 0; i <10 ; i++) {
            rabbitTemplate.convertAndSend("work","worl 模型");
        }

    }

    // 广播模型 绑定交换机 只和交换机发送消息
    @Test
    public  void  testFanout(){
        rabbitTemplate.convertAndSend("logs","","广播模型");
    }

    // 路由模式
    @Test
    public  void  testRoute(){
        rabbitTemplate.convertAndSend("RouteExchange","info","这是info路由key");
        rabbitTemplate.convertAndSend("RouteExchange","error","这是error路由key");
    }

}
