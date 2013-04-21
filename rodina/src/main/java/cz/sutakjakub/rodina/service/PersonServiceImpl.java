/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Person;
import cz.sutakjakub.rodina.bo.PersonType;
import cz.sutakjakub.rodina.dto.PersonDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author jey
 */
@Component
public class PersonServiceImpl extends AbstractDataAccessService implements PersonService {

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons = genericDao.getAll(Person.class);
        List<PersonDto> personsDto = new ArrayList<PersonDto>();
        for (Person person : persons) {
            personsDto.add(createPersonDto(person));
        }
        return personsDto;
    }

    @Override
    public PersonDto getPerson(Long id) {
        Person person = genericDao.getById(id, Person.class);
        PersonDto personDto = null;
        if (person != null) {
            personDto = createPersonDto(person);
        }
        return personDto;
    }

    @Override
    public Long addPerson(String name, String surname, Integer birth) {
        Person person = new Person();
        Long id = null;
        if (name != null && surname != null && birth != null) {
            person.setName(name);
            person.setSurname(surname);
            person.setBirth(birth);
            try {
                id = genericDao.saveOrUpdate(person).getId();
            } catch (Exception exp) {
            }
        }
        return id;
    }

    @Override
    public Long editPerson(String name, String surname, Integer birth, PersonType personType, List<Person> persons, List<Person> relative) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePerson(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRelation(Long personId, Long relativeId, PersonType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAverageAgeFamily(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDto createPersonDto(Person person) {
        PersonDto personDto = null;
        if (person.getId() != null && person.getName() != null
                && person.getSurname() != null && person.getBirth() != null) {
            personDto = new PersonDto(person.getId(), person.getName(), person.getSurname(),
                    person.getBirth());
        }

        return personDto;
    }
}
