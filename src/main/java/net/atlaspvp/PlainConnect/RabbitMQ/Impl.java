package net.atlaspvp.PlainConnect.RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Impl {



    private static int RabbitPort = 27003;
    private static String RabbitIP = "172.18.0.1";

    //public Channel channel; //channel to rabbit, used for sending and recieving

    private ConnectionFactory factory;

    private Connection connection;


    //public static String QUEUE_NAME = "atlascore";
    //public static String EXCHANGE = "exchange";

    public void initRabbitInstance() throws IOException, TimeoutException {
        //create factory
        factory = new ConnectionFactory();
        factory.setHost(RabbitIP);
        factory.setPort(RabbitPort);
        factory.setUsername("adfeahajulort");
        factory.setPassword("oyqiwebyif");
        connection = factory.newConnection();
        //channel = connection.createChannel();

    }

    public Channel createChannel() {
        try {
            return connection.createChannel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
