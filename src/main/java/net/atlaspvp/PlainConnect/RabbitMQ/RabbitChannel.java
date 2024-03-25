package net.atlaspvp.PlainConnect.RabbitMQ;

import com.rabbitmq.client.Channel;

import com.rabbitmq.client.DeliverCallback;

public class RabbitChannel {

    private final Channel channel;


    public RabbitChannel(Channel channel1){

        this.channel = channel1;
    }

    public void createListener(String exchange, String queue, String routingKey, DeliverCallback deliverCallback) throws Exception {


        //What if the queue, exchange dont exist yet?
        channel.queueBind(queue, exchange, routingKey);

        System.out.println(" [*] Waiting for messages, Exchange: " + exchange + ", Queue: " + queue + ", RoutingKey: " + routingKey);


        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
            System.out.println("Message Recieved");
        });

    }


    public void createExchange(String exchange, String type) throws Exception {
        channel.exchangeDeclare(exchange, type, false, false, null);
    }


    public void createQueue(String queue) throws Exception {
        //what is the purpose of queue, can we have multiple of them?
        channel.queueDeclare(queue, false, false, false, null);
    }


    public void send(String exchange, String key, byte[] message) throws Exception {
        //if exchange is "" it goes to all, if key = null it goes to all
        channel.basicPublish(key, key, null, message);
    }

}
