package org.example.server_topdown;


import java.util.ArrayList;
import java.util.List;

public class PersonRepository2Impl implements PersonRepository2 {
    private List<Person> personList;

    public PersonRepository2Impl() {
        personList = new ArrayList<>();

        Person p1 = new Person();
        p1.setId(1);
        p1.setFirstName("Mariusz");
        p1.setAge(22);

        Person p2 = new Person();
        p2.setId(2);
        p2.setFirstName("Kacper");
        p2.setAge(32);

        Person p3 = new Person();
        p3.setId(3);
        p3.setFirstName("Maria");
        p3.setAge(65);


        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
    }

    public List<Person> getAllPersons() {
        return personList;
    }

    public Person getPerson(int id) throws PersonNotFoundEx_Exception {
        for (Person thePerson : personList) {
            if (thePerson.getId() == id) {
                return thePerson;
            }
        }

        throw new PersonNotFoundEx_Exception("Person not found exception", new PersonNotFoundEx());
    }

    public Person addPerson(int id, String name, int age) throws PersonExistsEx_Exception{
        for (Person thePerson : personList) {
            if (thePerson.getId() == id) {
                throw new PersonExistsEx_Exception("Person already exists exception", new PersonExistsEx());
            }
        }
        Person person = new Person();
        person.setId(id);
        person.setFirstName(name);
        person.setAge(age);
        personList.add(person);

        return person;
    }

    public boolean deletePerson(int id) throws PersonNotFoundEx_Exception {
        for (Person thePerson : personList) {
            if (thePerson.getId() == id) {
                personList.remove(thePerson);
                return true;
            }
        }
        throw new PersonNotFoundEx_Exception("Person not found exception", new PersonNotFoundEx());
    }

    public int countPersons() {
        return personList.size();
    }
}
