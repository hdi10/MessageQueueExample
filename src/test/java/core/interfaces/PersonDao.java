/**
 * Dastekin created on 18.12.2022 the PersonDao-Class inside the package - core
 */

package core.interfaces;

import core.Person;

import java.util.List;

public interface PersonDao {
    Person find(Integer id);
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    List<Person> findAll();
    List<Person> findByLastname(String lastname);
}
