package org.example.server_topdown;


import jakarta.xml.ws.Endpoint;

import java.io.IOException;

import static java.lang.System.exit;

public class ServiceHost2 {
    public static void main(String[] args) {
        System.out.println("Web Service PersonService is running ...");
        PersonServiceImpl2 psi = new PersonServiceImpl2();
        Endpoint.publish("http://localhost:8082/personservice", psi);
        System.out.println("Press ENTER to STOP PersonService ...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }
}