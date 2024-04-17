package org.example.server_topdown;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "PersonService",
        endpointInterface = "org.example.server_topdown.PersonService")
public class PersonServiceImpl2 implements PersonService {
    private PersonRepository2 dataRepository = new PersonRepository2Impl();

    @WebMethod
    public List<Person> getAllPersons() {
        System.out.println("...called getAllPersons");
        return dataRepository.getAllPersons();
    }

    @WebMethod
    public Person getPerson(int id) throws PersonNotFoundEx_Exception {
        System.out.println("...called getPerson");
        return dataRepository.getPerson(id);
    }

    @WebMethod
    public Person addPerson(int id, String name, int age) throws PersonExistsEx_Exception {
        System.out.println("...called addPerson");
        return dataRepository.addPerson(id, name, age);
    }

    @WebMethod
    public boolean deletePerson(int id) throws PersonNotFoundEx_Exception {
        System.out.println("...called deletePerson");
        return dataRepository.deletePerson(id);
    }

    @WebMethod
    public int countPersons() {
        System.out.println("...called countPersons");
        return dataRepository.countPersons();
    }

}