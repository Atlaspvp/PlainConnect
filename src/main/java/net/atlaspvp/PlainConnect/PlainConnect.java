package net.atlaspvp.PlainConnect;

import net.atlaspvp.PlainConnect.RabbitMQ.Impl;
import net.atlaspvp.PlainConnect.RabbitMQ.RabbitChannel;

import java.nio.charset.StandardCharsets;

public class PlainConnect {

    public static void main(String[] args) {
        System.out.println("PlainConnect Starting...");

        try {
            rabbitConnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    private static void rabbitConnect() throws Exception {

        //init rabbitmq
        Impl rabbitInstance = new Impl();


        //create a new channel
        RabbitChannel rabbitChannel = new RabbitChannel(rabbitInstance.createChannel());

        //create an exchange on the channel
        rabbitChannel.createExchange("test-exchange", "direct");

        //create a queue on the channel
        rabbitChannel.createQueue("test-queue");

        //create a test listener, with a callback
        rabbitChannel.createListener("test-exchange", "test-queue", "test-key", (consumerTag, delivery) -> {
            //do something when message is recieved
            System.out.println("Message Recieved: " + new String(delivery.getBody(), StandardCharsets.UTF_8));


        });





    }
}
