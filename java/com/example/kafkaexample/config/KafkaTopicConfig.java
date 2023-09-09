/*This class is responsible for creating Kafka topics.
It defines a NewTopic bean named "example" using TopicBuilder. This topic is used for publishing and consuming messages.
 */

package com.example.kafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    //gets instantiated and we get a new topic
    @Bean
    //NewTopic comes from Kafka's admin package
    public NewTopic exampleTopic() {
        return TopicBuilder.name("example")
                .build();
    }
}
