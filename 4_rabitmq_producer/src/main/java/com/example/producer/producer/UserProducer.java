package com.example.producer.producer;

import com.example.producer.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer  {
    private final RabbitTemplate template;
    private ObjectMapper mapper=new ObjectMapper();

     public void sendMsg(User user){
         String value = null;
         try {
             value = mapper.writeValueAsString(user);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
         template.convertAndSend("x.hr","",value);
     }



}
