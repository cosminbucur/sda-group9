package com.bucur.crud;

public class DemoCrud {

    public static void main(String[] args) {
        Person person = createPerson();

        PersonDao personDao = new PersonDao();
        personDao.create(person);

        Person savedPerson = personDao.findById(1L);
        savedPerson.setFirstName("cristi");

        personDao.update(savedPerson);
        Person updatedPerson = personDao.findById(1L);

        personDao.delete(updatedPerson);
    }

    private static Person createPerson() {
        Person person = new Person();
        person.setFirstName("alex");
        person.setLastName("vasile");
        person.setEmail("alexvasile@gmail.com");
        person.setCountry("Romania");
        return person;
    }
}
