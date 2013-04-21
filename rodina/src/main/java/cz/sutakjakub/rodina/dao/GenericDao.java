/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.dao;

import cz.sutakjakub.rodina.bo.Person;
import java.util.List;

/**
 *
 * @author jey
 */
public interface GenericDao {

    /**
     * Vrati vsechny entity serazene sestupne dle id
     *
     * @return vsechny entity pozadovaneho typu (dle implementace potomka tohoto
     * interfacu)
     */
    public <ENTITY> List<ENTITY> getAll(Class<ENTITY> clazz);

    /**
     * Odstrani entitu dle jejiho id
     *
     * @param id entity k odstraneni
     */
    public <ENTITY extends Person> void removeById(long id, Class<ENTITY> clazz);

    /**
     * Ulozi nebo zaktualizuje danou entitu (at jiz je attached nebo detached),
     * entita bude po navratu teto funkce vzdy attached
     *
     * @param o
     * @return attached ulozeny (zaktualizovany objekt)
     */
    public <ENTITY extends Person> ENTITY saveOrUpdate(ENTITY o);

    /**
     * Vrati objekt (pomoci get) dane tridy dle ID
     *
     * @param id id objektu k vraceni
     * @return objekt identifikovany id,
     * @null pokud neexistuje
     */
    public <ENTITY> ENTITY getById(Long id, Class<ENTITY> clazz);

    /**
     * Load (proxy objektu) dle identifikatoru
     *
     * @param <ENTITY>
     * @param id
     * @param clazz
     * @return
     */
    public <ENTITY> ENTITY loadById(long id, Class<ENTITY> clazz);

    /**
     * Vrati vsechny instance razene sestupne dle property
     *
     * @param property
     * @return
     */
    public <ENTITY> List<ENTITY> getAllOrderedDesc(String property, Class<ENTITY> clazz);

    /**
     * Vrati vsechny instance razene vzestupne dle property
     *
     * @param property
     * @return
     */
    public <ENTITY> List<ENTITY> getAllOrderedAsc(String property, Class<ENTITY> clazz);

    public <ENTITY> List<ENTITY> getAllOrderedAsc(String orderedProperty, String property, Object value, Class<ENTITY> clazz);

    public <ENTITY> List<ENTITY> getAllOrderedDesc(String orderedProperty, String property, Object value, Class<ENTITY> clazz);

    /**
     * Get all entities by property
     *
     * @param property the property to select
     * @param value value of the property
     * @return
     */
    public <ENTITY> List<ENTITY> getByProperty(String property, Object value, Class<ENTITY> clazz);

    /**
     * Get all entities by property
     *
     * @param property the property to select
     * @param value value of the property
     * @return
     */
    public <ENTITY> ENTITY getByPropertyUnique(String property, Object value, Class<ENTITY> clazz);
}