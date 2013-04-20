/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.dto.FatherDto;
import cz.sutakjakub.rodina.dto.MotherDto;
import java.util.List;
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
public class FatherServiceTest extends AbstractServiceTest{
    
    @Autowired
    private FatherService fs;
    
    @Autowired
    private MotherService ms;
    
    public FatherServiceTest() {
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
     * Test of getAllFather method, of class FatherServiceImpl.
     */
    @Test
    public void testGetAllFather() {
        System.out.println("getAllFather");
        fs.addFather("stanislav", "sutak", new Integer(44));
        fs.addFather("pavel", "ondrusek", new Integer(22));
        fs.addFather("honza", "hybl", new Integer(18));
     
        assertEquals(3, fs.getAllFather().size());
    }

    /**
     * Test of getFather method, of class FatherServiceImpl.
     */
    @Test
    public void testGetFather() {
        System.out.println("getFather");
        fs.addFather("stanislav", "sutak", new Integer(44));
        fs.addFather("pavel", "sutak", new Integer(22));
        Long id = fs.addFather("honza", "sutak", new Integer(18));
        
        List<FatherDto> fathers = fs.getFather("sutak");
        assertEquals(3, fathers.size());
        
        FatherDto father = fs.getFatherById(id);
        assertEquals("honza", father.getName());
        assertEquals(father.getName(), fathers.get(0).getName());
    }

    /**
     * Test of getFatherById method, of class FatherServiceImpl.
     */
    @Test
    public void testGetFatherById() {
        System.out.println("getFatherById");
         Long id = fs.addFather("honza", "sutak", new Integer(18));
        FatherDto father = fs.getFatherById(id);
        assertEquals(id, father.getId());
    }

    /**
     * Test of getWife method, of class FatherServiceImpl.
     */
    @Test
    public void testGetWife() {
        System.out.println("getWife");
        Long fatherId = fs.addFather("stanislav", "sutak", new Integer(42));
        Long motherId = ms.addMother("renata", "sutakova", new Integer(40));
        
        fs.addWife(fatherId, motherId);
        MotherDto mDto = ms.getMotherById(motherId);
        
        assertEquals(motherId, mDto.getId());
    }
    
    /**
     * Test of addWife method, of class FatherService.
     */
    @Test
    public void testAddWife() {
        System.out.println("addWife");
        Long fatherId = fs.addFather("stanislav", "sutak", new Integer(42));
        Long motherId = ms.addMother("renata", "sutakova", new Integer(40));
        
        fs.addWife(fatherId, motherId);
        FatherDto fDto = fs.getFatherById(fatherId);
        assertEquals(motherId, fDto.getMother().getId());
    }

    /**
     * Test of addFather method, of class FatherServiceImpl.
     */
    @Test
    public void testAddFather() {
        System.out.println("addFather");
        Long id1 = fs.addFather("stanislav", "sutak", new Integer(44));
        Long id2 = fs.addFather("pavel", "sutak", new Integer(22));
        
        FatherDto father = fs.getFatherById(id1);
        assertEquals(id1, father.getId());
        
        father = fs.getFatherById(id2);
        assertEquals(id2, father.getId());
    }

    /**
     * Test of editFather method, of class FatherServiceImpl.
     */
    @Test
    public void testEditFather() {
        System.out.println("editFather");
        Long id = fs.addFather("stanislav", "sutak", new Integer(44));
        FatherDto father = fs.getFatherById(id);
        
        assertEquals("stanislav", father.getName());
        fs.editFather(id, "tomas", "svoboda", new Integer(28));
        
        father = fs.getFatherById(id);
        assertEquals("tomas", father.getName());
        assertEquals("svoboda", father.getSurname()); 
    }

    /**
     * Test of deleteFather method, of class FatherServiceImpl.
     */
    @Test
    public void testDeleteFather() {
        System.out.println("deleteFather");
        Long id = fs.addFather("renata", "sutakova", new Integer(40));
        
        FatherDto mother = fs.getFatherById(id);
        assertEquals(id, mother.getId());
        
        fs.deleteFather(id);
        
        mother = fs.getFatherById(id);
        assertNull(mother);
    }
}