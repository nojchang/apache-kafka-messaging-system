# apache-kafka-messaging-system

This Spring Boot application demonstrates a simple messaging system using Apache Kafka. It allows you to produce and consume messages via Kafka topics. In this README, we'll explore the key components and functionality of the application.

## Table of Contents
- [Overview](#overview)
- [Setting up Kafka Locally](#setting-up-kafka-locally)
- [Building and Running the Application](#building-and-running-the-application)
- [Application Components](#application-components)
  - [Kafka Producer](#kafka-producer)
  - [Kafka Consumer](#kafka-consumer)
  - [RESTful API for Message Publishing](#restful-api-for-message-publishing)
- [Configuration](#configuration)
- [How to Run](#how-to-run)
- [Setting Up a Kafka Consumer](#setting-up-a-kafka-consumer)
- [Dependencies](#dependencies)

## Setting up Kafka Locally

To run this application, you'll need to set up Kafka locally. Follow these steps:

1. Go to the official Apache Kafka page at [kafka.apache.org](https://kafka.apache.org).

2. Navigate to **GET STARTED** at the top of the page and click on **QUICKSTART**.

3. In **STEP 1: GET KAFKA**, download the latest release by clicking the HTTP link. Save the downloaded file to your "Downloads" folder.

4. Open your terminal and navigate to the "Downloads" folder using the following commands:
   ```bash
   cd ~/Downloads
   ```

5. Next, navigate into the Kafka directory. Depending on the version you downloaded, your directory name may vary. Replace `<kafka_version>` with your Kafka version (e.g., `kafka_2.13-3.5.0`):
   ```bash
   cd kafka_<kafka_version>
   ```

6. In **STEP 2: START THE KAFKA ENVIRONMENT**, start the ZooKeeper service (where Kafka stores all its configuration) using the following command:
   ```bash
   bin/zookeeper-server-start.sh config/zookeeper.properties
   ```
![Screen Shot 2023-09-08 at 5 54 11 PM](https://github.com/nojchang/apache-kafka-messaging-system/assets/69415781/f79cf8bc-8311-473d-b2b6-6b1f2bb3c89f)


7. Open a new terminal window (leave the previous one running) and navigate to the "Downloads" folder again:
   ```bash
   cd ~/Downloads
   ```

8. Navigate into the Kafka directory once more:
   ```bash
   cd kafka_<kafka_version>
   ```

9. To start the Kafka Broker service, use the following command:
   ```bash
   bin/kafka-server-start.sh config/server.properties
   ```

10. You will see a message in the terminal stating "From now on will use broker localhost:9092." This indicates that Kafka is up and running locally.

Now that Kafka is set up on your machine, you can proceed with building and running the Spring Boot application.

## Building and Running the Application

To build and run the Spring Boot application:

1. Open IntelliJ IDEA (or your preferred Java IDE).

2. Create a new project named "Kafka-example" using Spring Initializer.

3. Add the following dependencies to your project:
   - Spring Web (to build a RESTful API)
   - Spring for Apache Kafka (public, subscribe, store, and process streams of records, project all bootstrapped)

4. Clone or download this repository to your local machine.

5. Import the downloaded project into IntelliJ IDEA.

6. Ensure you have Apache Kafka installed and running with default settings (`localhost:9092`).

7. Build and run the Spring Boot application.

8. The application will send 100 sample messages to the "example" Kafka topic upon startup.

9. You can use the provided RESTful API endpoint (`POST /api/v1/messages`) to publish additional messages to the topic.

10. Kafka consumers will listen to the "example" topic and print received messages to the console.

## Overview

This Spring Boot application provides a messaging system that utilizes Apache Kafka for message processing. It comprises three main components:

### Kafka Producer

- The `KafkaApplication` class sets up the Spring Boot application and configures the Kafka producer to send messages.
- A `CommandLineRunner` bean sends 100 sample messages to a Kafka topic named "example" when the application starts.
- The producer sends messages to the Kafka topic, allowing consumers to subscribe and receive them.

### Kafka Consumer

- The `KafkaListeners` class is responsible for consuming messages/events from the "example" Kafka topic.
- It uses the `@KafkaListener` annotation to listen to the "example" topic and prints received messages to the console.
- Multiple instances of the application can use a common `groupId` to read messages from the same partition or topic.

### RESTful API for Message Publishing

- The `MessageController` class defines a RESTful API endpoint at `/api/v1/messages`.
- Clients can use this endpoint to publish messages to the Kafka topic.
- Messages are sent as POST requests to this endpoint, and the `KafkaTemplate` is used to transmit messages to the "example" Kafka topic.

## Configuration

- The Kafka producer and consumer configurations are specified in the `KafkaProducerConfig` and `KafkaConsumerConfig` classes, respectively.
- Kafka topics are defined using the `KafkaTopicConfig` class, which creates a topic named "example."
- Application properties, including the Kafka server's address, are configured in the `application.properties` file.

## How to Run

After completing the Kafka setup and building the Spring Boot application, follow these steps to run the Kafka consumer and observe the events:

### Setting Up a Kafka Consumer

1. Open another terminal (the third one so far).

2. Navigate to your "Downloads" folder:
   ```bash
   cd ~/Downloads
   ```

3. Navigate into the Kafka directory:
   ```bash
   cd kafka_<kafka_version>
   ```

4. Run the console consumer client to read the events you just created. Use the following command, but make sure to change `"--topic quickstart-events"` to `"--topic example"`:
   ```bash
   bin/kafka-console-consumer.sh --topic example --from-beginning --bootstrap-server localhost:9092
   ```

You will now see messages being consumed from the "example" Kafka topic in the terminal and on the console. We have 2 Consumers reading from the same topic.
![Screen Shot 2023-09-08 at 6 24 02 PM](https://github.com/nojchang/apache-kafka-messaging-system/assets/69415781/90b28318-c14c-4125-b7f5-def55906e09a)


And the RESTful api allow us to publish message to a queue. Which is publish to a topic and the Consumer reads it out. 
![Screen Shot 2023-09-08 at 6 26 41 PM](https://github.com/nojchang/apache-kafka-messaging-system/assets/69415781/42d32b4d-aad6-43df-bed8-cd9587a08c80)


## Dependencies

- Spring Boot
- Apache Kafka
- Spring Kafka

