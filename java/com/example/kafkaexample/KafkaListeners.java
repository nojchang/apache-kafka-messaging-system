/*This class is responsible for consuming messages/events from the "example" Kafka topic.
It uses the @KafkaListener annotation to listen to the "example" topic and prints received messages to the console.
 */
package com.example.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "example",
            groupId = "groupId" //if we scale, i.e. if we have more instances of the same application,
                                // they can read from the same partition or topic
    )
    //a method creates a listener that listens on our topic
    void listener(String data) {
        System.out.println("Listener received: " + data + " Well done Jon Chang! =D ");
    }
}
