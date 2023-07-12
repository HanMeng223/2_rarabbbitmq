package com.example;

import com.example.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {


    @Autowired
    RabbitTemplate rabbitTemplate;


    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    void contextLoads() {


        //Message需要自己定义一个消息，定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routeKey,message)

        //object默认为消息体，只需要传入要发动的对象，自动序列化发送给rabitmq
//        rabbitTemplate.convertAndSend(exchange,routeKer,object);
//        Map<String,Object> map=new HashMap<>();
//        map.put("msg","这是第一个消息");
//        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化后发送
        //将数据转化为Json发送出去(s使用自定义配置）
//        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
        Book book=new Book("西游记","吴承恩");
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",book);


    }

    //接收数据
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }




    //广播
    @Test
    public void tset2(){
        Book book=new Book("西游记","吴承恩");
        rabbitTemplate.convertAndSend("exchange.fanout","",book);
    }

    @Test
    public void createExChange(){
        //创建交换机
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        //创建队列
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        //绑定交换机与队列
//        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
//                                            Binding.DestinationType.QUEUE,
//                                    "amqpadmin.exchange",
//                                    "amqp.haha",
//                                        null));

        
    }



}
