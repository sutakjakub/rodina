/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Person;
import cz.sutakjakub.rodina.bo.PersonToPerson;
import cz.sutakjakub.rodina.dto.PersonDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jey
 */
@Component
public class PersonServiceImpl extends AbstractDataAccessService implements PersonService {

    @Autowired
    private PersonToPersonService p2ps;

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
    public Long editPerson(Long id, String name, String surname, Integer birth) {
        Long idPerson = null;
        Person per = genericDao.getById(id, Person.class);
        if (name != null && surname != null && birth != null) {
            per.setName(name);
            per.setSurname(surname);
            per.setBirth(birth);
            try {
                idPerson = genericDao.saveOrUpdate(per).getId();
            } catch (Exception exp) {
            }
        }
        return idPerson;
    }

    @Override
    public void deletePerson(Long id) {
        if (id != null) {
            try {
                genericDao.removeById(id, Person.class);
            } catch (Exception exp) {
            }
        }
    }

    @Override
    public double getAverageAgeFamily(Long id) {
        Double average = null;
        Person per = null;
        List<PersonToPerson> p2p = null;
        if (id != null) {
            try {
                per = genericDao.getById(id, Person.class);
            } catch (Exception exp) {
            }
            if (per != null) {
                p2p = p2ps.getRelations(id);
                if (p2p != null) {
                    average = (double) per.getBirth();
                    for (PersonToPerson personToPerson : p2p) {
                        if (personToPerson.getPerson1().getId() == id) {
                            average += personToPerson.getPerson2().getBirth();
                        }
                        if (personToPerson.getPerson2().getId() == id) {
                            average += personToPerson.getPerson1().getBirth();
                        }
                    }
                }
            }
        }
        return average;
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
