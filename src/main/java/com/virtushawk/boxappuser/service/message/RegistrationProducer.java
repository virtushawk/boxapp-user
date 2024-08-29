package com.virtushawk.boxappuser.service.message;

import com.virtushawk.boxappuser.conf.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrationProducer {

    private final RabbitTemplate rabbitTemplate;

    public RegistrationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendStringMessage(String key, String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME, key, message);
    }
}
