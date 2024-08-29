package com.virtushawk.boxappuser.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String UNREGISTER_QUEUE_NAME = "boxapp.queue.event.unregister";
    public static final String EXCHANGE_NAME = "boxapp.exchange";

    @Bean
    public Queue queue() {
        return new Queue(UNREGISTER_QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("event.unregister");
    }
}
