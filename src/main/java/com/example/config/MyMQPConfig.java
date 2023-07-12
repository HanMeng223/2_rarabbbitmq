package com.example.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMQPConfig {
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }




    @Bean
    public Queue direct(){
        return new Queue("direct_queue");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }


    @Bean
    public Binding binding(){
        return BindingBuilder.bind(direct()).to(directExchange()).with("direct");
    }


}
