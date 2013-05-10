/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Person;
import cz.sutakjakub.rodina.bo.PersonToPerson;
import cz.sutakjakub.rodina.bo.PersonType;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jey
 */
@Transactional
public interface PersonToPersonService {
    
    /**
     * Vrátí průměrný věk celé rodiny od parametru person
     * @param person
     * @return 
     */
    @Transactional(readOnly = true)
    public double getAvarageAge(Person person);
    
    /**
     * Přidá vztah mezi dvěmi osobami
     * @param per1
     * @param per2
     * @param type
     */
    @Transactional(readOnly = true)
    public void addRelation(Person per1, Person per2, PersonType type);
    
    /**
     * Vrací vztah mezi dvěmi osobami
     * @param per1
     * @param per2
     * @return 
     */
    @Transactional(readOnly = true)
    public PersonType getPersonType(Person per1, Person per2);
    
    /**
     * Vrátí všechny rodinné příslušníky
     * @param per
     * @return 
     */
    @Transactional(readOnly = true)
    public List<Person> getFamily(Person per);
    
    /**
     * Vrátí všechny vzájemné relace s parametrem id
     * @param id
     * @return 
     */
    @Transactional(readOnly = true)
    public List<PersonToPerson> getRelations(Long id);
}
