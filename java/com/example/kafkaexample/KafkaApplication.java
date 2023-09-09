/*This is the main class of the Spring Boot application.
It includes a CommandLineRunner bean that sends 100 messages to a Kafka topic named "example" when the application starts.
This class sets up the Spring Boot application and configures the Kafka producer to send messages.
 */
package com.example.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
    //CommandLineRunner will receive the Kafka Template that was defined in KafkaProducerConfig
    @Bean
    CommandLineRunner commandLineRunner (KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            //to show an example of how Kafka can read everything from the topic really fast with no issues
            for (int i = 0; i < 100; i++) {
                kafkaTemplate.send("example", "hello this is Jon Chang :)" + i); //Sending the message "hello kafka :)" to the topic: example (within KafkaTopicConfig.java)
            }
        };
    }
}
