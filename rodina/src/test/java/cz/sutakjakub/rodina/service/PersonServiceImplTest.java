/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jey
 */
public class PersonServiceImplTest extends AbstractServiceTest{
    
    @Autowired
    private PersonService ps;
    
    public PersonServiceImplTest() {
        super();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllPersons method, of class PersonServiceImpl.
     */
    @Test
    public void testGetAllPersons() {
        ps.addPerson("kuba", "sutak", new Integer(21));
        ps.addPerson("pavel", "komarek", new Integer(20));
        ps.addPerson("tomas", "penkava", new Integer(10));
               
        assertEquals(3, ps.getAllPersons().size());
    }

    /**
     * Test of getPerson method, of class PersonServiceImpl.
     */
    @Test
    public void testGetPerson() {
        
    }

    /**
     * Test of addPerson method, of class PersonServiceImpl.
     */
    @Test
    public void testAddPerson() {
//        System.out.println("addPerson");
//        ps.addPerson("kuba", "sutak", new Integer(21));
//        ps.addPerson("pavel", "komarek", new Integer(20));
//        Long id = ps.addPerson("tomas", "penkava", new Integer(10));
//        
//                       
//        assertEquals(3, ps.getAllPersons().size());
    }

    /**
     * Test of editPerson method, of class PersonServiceImpl.
     */
    @Test
    public void testEditPerson() {
        System.out.println("editPerson");
        
    }

    /**
     * Test of deletePerson method, of class PersonServiceImpl.
     */
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        
    }

    /**
     * Test of addRelation method, of class PersonServiceImpl.
     */
    @Test
    public void testAddRelation() {
        System.out.println("addRelation");
       
    }

    /**
     * Test of getAverageAgeFamily method, of class PersonServiceImpl.
     */
    @Test
    public void testGetAverageAgeFamily() {
        System.out.println("getAverageAgeFamily");
        
    }

    /**
     * Test of createPersonDto method, of class PersonServiceImpl.
     */
    @Test
    public void testCreatePersonDto() {
        System.out.println("createPersonDto");
        
    }
}