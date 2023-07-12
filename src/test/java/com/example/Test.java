package com.example;

import com.example.pojo.Book;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @org.junit.jupiter.api.Test
    public void t(){
        Book book=new Book("西游记","吴承恩2");
        amqpTemplate.convertAndSend("direct_queue",book);

    }


    @org.junit.jupiter.api.Test
    public void qwe(){
        Book book=new Book("西游记","吴承恩2");
//        amqpTemplate.convertAndSend("exchange.topic","atguigu.news",book);
        rabbitTemplate.convertAndSend("exchange.topic","atguigu.news",book);
    }
}
