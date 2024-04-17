package org.example.server_topdown;



import java.util.List;

public interface PersonRepository2 {
    List<Person> getAllPersons();
    Person getPerson(int id) throws PersonNotFoundEx_Exception;
    Person addPerson(int id, String name, int age) throws PersonExistsEx_Exception;
    boolean deletePerson(int id) throws PersonNotFoundEx_Exception;
    int countPersons();
}

