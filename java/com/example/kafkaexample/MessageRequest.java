/*This class represents the structure of the message requests received by the MessageController.
It is a simple Java record with a single message field.
 */
package com.example.kafkaexample;

public record MessageRequest(String message) {
}
