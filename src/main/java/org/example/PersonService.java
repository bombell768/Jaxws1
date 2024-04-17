package org.example;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;


@WebService
public interface PersonService {
    @WebMethod
    List<Person> getAllPersons();
    @WebMethod
    Person getPerson(@WebParam(name="id") int id) throws PersonNotFoundEx;
    @WebMethod
    Person addPerson(@WebParam(name="id") int id,
                     @WebParam(name="firstName") String name,
                     @WebParam(name="age") int age) throws PersonExistsEx;
    @WebMethod
    boolean deletePerson(@WebParam(name="id") int id)
            throws PersonNotFoundEx;
    @WebMethod
    int countPersons();
    @WebMethod
    boolean updatePerson(@WebParam(name="id") int id,
                     @WebParam(name="firstName") String name,
                     @WebParam(name="age") int age) throws PersonNotFoundEx;

}
