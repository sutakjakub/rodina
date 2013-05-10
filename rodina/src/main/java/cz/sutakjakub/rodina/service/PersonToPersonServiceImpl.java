/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Person;
import cz.sutakjakub.rodina.bo.PersonToPerson;
import cz.sutakjakub.rodina.bo.PersonType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author jey
 */
@Component
public class PersonToPersonServiceImpl extends AbstractDataAccessService implements PersonToPersonService {

    @Override
    public double getAvarageAge(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRelation(Person per1, Person per2, PersonType type) {
        Long id = null;
        PersonToPerson p2p = new PersonToPerson();
        if (per1 != null && per2 != null && type != null) {
            p2p.setPerson1(per1);
            p2p.setPerson2(per2);
            p2p.setPersonType(type);
            try {
                genericDao.saveOrUpdateP2p(p2p);
            } catch (Exception exp) {
            }
        }
    }

    @Override
    public PersonType getPersonType(Person per1, Person per2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getFamily(Person per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonToPerson> getRelations(Long id) {
        List<PersonToPerson> p2pFirst = null;
        List<PersonToPerson> p2pSecond = null;
        List<PersonToPerson> p2ps = null;
        if (id != null) {
            try {
                p2pFirst = genericDao.getByProperty("PERSON_ID1", id, PersonToPerson.class);
                p2pSecond = genericDao.getByProperty("PERSON_ID2", id, PersonToPerson.class);
            } catch (Exception exp) {
            }
            
            p2ps = new ArrayList<PersonToPerson>(p2pFirst);
            p2ps.addAll(p2pSecond);   
        }
        return p2ps;
    }
}
