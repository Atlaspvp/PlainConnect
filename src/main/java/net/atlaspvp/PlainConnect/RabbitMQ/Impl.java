package net.atlaspvp.PlainConnect.RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Impl {

    public static ConnectionFactory factory;
    public static int RabbitPort = 27003;
    public static String RabbitIP = "172.18.0.1";

    public static String QUEUE_NAME = "atlascore";
    public static String EXCHANGE = "exchange";

    public static void onEnable() {
        //create factory
        factory = new ConnectionFactory();
        factory.setHost(RabbitIP);
        factory.setPort(RabbitPort);
        factory.setUsername("adfeahajulort");
        factory.setPassword("oyqiwebyif");


        //start the reciever
        try {
            Receive.receive();
            Send.send();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
