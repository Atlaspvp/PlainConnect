package net.atlaspvp.PlainConnect;

import net.atlaspvp.PlainConnect.RabbitMQ.Impl;

public class PlainConnect {

    public static void main(String[] args) {
        System.out.println("PlainConnect Starting...");
        Impl.onEnable();
    }
}
