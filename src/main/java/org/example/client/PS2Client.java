package org.example.client;

import org.example.server_topdown.*;

import java.net.MalformedURLException;
import java.net.URL;

public class PS2Client {
    public static void main(String[] args) throws MalformedURLException,
            PersonNotFoundEx_Exception
    {
        int num =-1;
        URL addr = new URL("http://localhost:8082/personservice?wsdl");
        PersonService_Service pService = new PersonService_Service();
        PersonService pServiceProxy = pService.getPersonServiceImplPort();

        for(Person person : pServiceProxy.getAllPersons())
        {
            System.out.println("Person: "+person.getFirstName()+", id = "+person.getId()+", age = "+person.getAge());
        }
        System.out.println();

        try {
            pServiceProxy.addPerson(4, "Bartosz", 222);
        } catch (PersonExistsEx_Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            pServiceProxy.deletePerson(2);
        } catch (PersonNotFoundEx_Exception e) {
            System.out.println(e.getMessage());
        }

        for(Person person : pServiceProxy.getAllPersons())
        {
            System.out.println("Person: "+person.getFirstName()+", id = "+person.getId()+", age = "+person.getAge());
        }
        System.out.println();

        try {
            pServiceProxy.addPerson(4, "Bartosz", 222);
        } catch (PersonExistsEx_Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            pServiceProxy.deletePerson(2);
        } catch (PersonNotFoundEx_Exception e) {
            System.out.println(e.getMessage());
        }


    }
}