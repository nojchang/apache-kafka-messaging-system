/*This class defines a RESTful API endpoint /api/v1/messages that allows clients to publish messages to the Kafka topic.
It uses a KafkaTemplate to send messages to the "example" Kafka topic.
Messages are sent when a POST request is made to this endpoint.
 */
package com.example.kafkaexample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping //PostMapping expose this method to our clients, to issue post requests against it
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("example", request.message());
    }
}
