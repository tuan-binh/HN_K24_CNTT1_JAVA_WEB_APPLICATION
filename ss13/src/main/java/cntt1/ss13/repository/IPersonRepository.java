package cntt1.ss13.repository;

import cntt1.ss13.model.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> findAll();
    void save(Person person);
}
