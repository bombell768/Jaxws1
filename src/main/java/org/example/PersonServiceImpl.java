package org.example;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;

import java.util.List;

@WebService(serviceName = "PersonService",
        endpointInterface = "org.example.PersonService")
public class PersonServiceImpl implements PersonService {
    private PersonRepository dataRepository = new PersonRepositoryImpl();

    @WebMethod
    public List<Person> getAllPersons() {
        System.out.println("...called getAllPersons");
        return dataRepository.getAllPersons();
    }

    @WebMethod
    public Person getPerson(int id) throws PersonNotFoundEx {
        System.out.println("...called getPerson");
        return dataRepository.getPerson(id);
    }

    @WebMethod
    public Person addPerson(int id, String name, int age) throws PersonExistsEx {
        System.out.println("...called addPerson");
        return dataRepository.addPerson(id, name, age);
    }

    @WebMethod
    public boolean deletePerson(int id) throws PersonNotFoundEx {
        System.out.println("...called deletePerson");
        return dataRepository.deletePerson(id);
    }
    @WebMethod
    public int countPersons() {
        System.out.println("...called countPersons");
        return dataRepository.countPersons();
    }

    @WebMethod
    public boolean updatePerson(int id, String name, int age) throws PersonNotFoundEx {
        System.out.println("...called updatePerson");
        return dataRepository.updatePerson(id, name, age);
    }
}