package com.example.producer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FixRatingProducer {
    private final RabbitTemplate  template;
    private Logger  logger;
    private int i=0;
    @Scheduled(fixedRate = 200)
    public void sendMsg(){
        i++;
        logger= LoggerFactory.getLogger(this.getClass());
        logger.info("msg "+i+" send.");
        template.convertAndSend("fix_rating_queue","msg number: "+i);
    }
}
