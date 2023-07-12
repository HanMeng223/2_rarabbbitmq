package com.example.service;

import com.example.pojo.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface BookService {

    @RabbitListener(queues = {"atguigu.news","direct_queue"})
    public void receive(Message message,Book book);


    @RabbitListener(queues = "atguigu")
    public void receive2(Message message);
}
