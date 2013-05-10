/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.dao;

import cz.sutakjakub.rodina.bo.PersonToPerson;

/**
 *
 * @author jey
 */
public class PersonToPersonDAO extends GenericHibernateJpaDao {

    public void saveOrUpdateP2p(PersonToPerson p2p) {
        
        if (p2p.getPk() == null) {
            getEntityManager().persist(p2p);
        } else {
            getEntityManager().merge(p2p);
        }
    }
}
