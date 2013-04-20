/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.dao;

import cz.sutakjakub.rodina.bo.AbstractBusinessObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author jey
 */
@Component("genericDao")
public class GenericHibernateJpaDao implements GenericDao{
    
    @Autowired
    protected EntityManagerFactory entityManagerfactory;

    /**
     * Get entity manager for the current transaction
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerfactory); //entity manager with @Transactional support
    }

    /**
     * Vrati vsechny objekty dane tridy
     *
     * @return vsechny objekty tridy, jez je injektovana jako clazz, serazene
     * dle id sestupne
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getAll(Class<ENTITY> clazz) {
        return getEntityManager().createQuery("SELECT e FROM " + clazz.getSimpleName() + " e").getResultList();
    }

    /**
     * Vrati vsechny objekty serazene sestupne dle dane property
     *
     * @param property
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getAllOrderedDesc(String property, Class<ENTITY> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e ORDER BY e." + property + " DESC";
        return getEntityManager().createQuery(queryString).getResultList();
    }

    /**
     * Vrati vsechny objekty serazene vzestupne dle dane property
     *
     * @param property
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getAllOrderedAsc(String property, Class<ENTITY> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e ORDER BY e." + property + " ASC";
        return getEntityManager().createQuery(queryString).getResultList();
    }
    
    /**
     * Vrati objekty dane tridy serazene sestupne dle dane property, jejichz property se rovna objektu predanemu v
     * parametru, serazene dle id sestupne
     *
     * @param property
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getAllOrderedDesc(String orderedProperty, String property, Object value, Class<ENTITY> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " = :value ORDER BY e." + orderedProperty + " DESC";
        return getEntityManager().createQuery(queryString).setParameter("value", value).getResultList();
    }

    /**
     * Vrati objekty dane tridy serazene vzestupne dle dane property, jejichz property se rovna objektu predanemu v
     * parametru, serazene dle id sestupne
     *
     * @param property
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getAllOrderedAsc(String orderedProperty, String property, Object value, Class<ENTITY> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " = :value ORDER BY e." + orderedProperty + " ASC";
        return getEntityManager().createQuery(queryString).setParameter("value", value).getResultList();
    }

    /**
     * Vrati objekty dane tridy, jejichz property se rovna objektu predanemu v
     * parametru, serazene dle id sestupne
     *
     * @param property property, kterou porovnavame
     * @param value hodnota, se kterou porovnavame
     * @return vsechny vyhovujici zaznamy
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getByProperty(String property, Object value, Class<ENTITY> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " = :value";
        return getEntityManager().createQuery(queryString).setParameter("value", value).getResultList();
    }
   
    /**
     * Smaze objekt dle daneho ID
     *
     * @param id id objektu je smazani
     */
    @Override
    public <ENTITY extends AbstractBusinessObject> void removeById(long id, Class<ENTITY> clazz) {
        ENTITY e = getEntityManager().find(clazz, id);
        if (e != null) {
            getEntityManager().remove(e);
        }
    }


    /**
     * Vrati objekt (pomoci get) dane tridy dle ID
     *
     * @param id id objektu k vraceni
     * @return objekt identifikovany id,
     * @null pokud neexistuje
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> ENTITY getById(Long id, Class<ENTITY> clazz) {
        return getEntityManager().find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> ENTITY loadById(long id, Class<ENTITY> clazz) {
        return (ENTITY) ((Session) getEntityManager().getDelegate()).load(clazz, id);
    }

    @Override
    public <ENTITY extends AbstractBusinessObject> ENTITY saveOrUpdate(ENTITY o) {
        if (o.getId() == null) {
            getEntityManager().persist(o);
        } else {
            getEntityManager().merge(o);
        }
        return o;
    }

    @Override
    public <ENTITY> ENTITY getByPropertyUnique(String property, Object value, Class<ENTITY> clazz) {
        ENTITY e; 
        if (value == null) {
            e = clazz.cast(getEntityManager().createQuery("SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " IS NULL").getSingleResult());
        } else {
            e = clazz.cast(getEntityManager().createQuery("SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " = :value").setParameter("value", value).getSingleResult());
        }
        return e;
    }
}
