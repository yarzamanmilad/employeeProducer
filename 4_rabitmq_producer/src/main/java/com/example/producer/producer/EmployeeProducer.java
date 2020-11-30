package com.example.producer.producer;

import com.example.producer.domain.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeProducer {
    private final RabbitTemplate template;
    private  ObjectMapper mapper=new ObjectMapper();
    public void sendMessage(Employee employee){

        try {
            String json = mapper.writeValueAsString(employee);
            template.convertAndSend("employee-q",json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
