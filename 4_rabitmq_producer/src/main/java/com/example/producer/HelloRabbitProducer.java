package com.example.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloRabbitProducer {

    private final RabbitTemplate rabbitTemplate;
    public void SendHello(String txt){
        rabbitTemplate.convertAndSend("hello-queue",txt);

    }
}
