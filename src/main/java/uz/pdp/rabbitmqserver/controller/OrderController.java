package uz.pdp.rabbitmqserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.rabbitmqserver.model.Order;

@RestController
@RequiredArgsConstructor
public class OrderController {
    @Value("${rabbitMq.topic.exchange.name}")
    private String exchangeName;
    @Value("${rabbitMq.topic.route.key.name}")
    private String routingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/order/send")
    public void sendMessage(@RequestBody Order order) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, order);
    }
}
