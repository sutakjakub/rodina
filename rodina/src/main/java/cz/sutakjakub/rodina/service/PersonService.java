/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Person;
import cz.sutakjakub.rodina.bo.PersonType;
import cz.sutakjakub.rodina.dto.PersonDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jey
 */
@Transactional
public interface PersonService {

    /**
     * Vrátí všechny objekty Person z databáze
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<PersonDto> getAllPersons();

    /**
     * Vráti objekt Person podle jeho id
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public PersonDto getPerson(Long id);

    /**
     * Vytvoří nový objekt Person a uloží jej do databáze
     * 
     * @param name
     * @param surname
     * @param birth
     * @param personType
     * @param persons
     * @param relative
     * @return
     */
    @Transactional(readOnly = true)
    public Long addPerson(String name, String surname, Integer birth);
    
    /**
     * Edituje objekt a uloží jej do databáze
     * @param name
     * @param surname
     * @param birth
     * @return 
     */
    @Transactional(readOnly = true)
    public Long editPerson(Long id, String name, String surname, Integer birth);
    
    /**
     * Smaže objekt Person podle jeho id
     * 
     * @param id 
     */
    @Transactional(readOnly = true)
    public void deletePerson(Long id);
    
    /**
     * Spočítá průměrný věk rodiny, tzv udělá se věkový průměr z každého Persona, který
     * má nějakou vazbu na Persona, který se najde pomocí jeho id @param
     * 
     * @param id
     * @return 
     */
    @Transactional(readOnly = true)
    public double getAverageAgeFamily(Long id);    
    
    /**
     * Transformuje Person na PersonDto
     * 
     * @param person
     * @return 
     */
    @Transactional(readOnly = true)
    public PersonDto createPersonDto(Person person);
}
