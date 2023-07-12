package com.example.service.impl;


import com.example.pojo.Book;
import com.example.service.BookService;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
public class BookserviceImpl implements BookService {


    @Override
    public void receive(Message message,Book book) {
        System.out.println("receive1:"+message.getBody());
        System.out.println("receive1:"+message.getMessageProperties());
        System.out.println("收到消息"+book);
    }

    @Override
    public void receive2(Message message) {
        System.out.println("receive2:"+message.getBody());
        System.out.println("receive2:"+message.getMessageProperties());
    }
}
