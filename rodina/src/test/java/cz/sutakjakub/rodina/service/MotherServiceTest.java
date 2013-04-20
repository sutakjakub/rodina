/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Father;
import cz.sutakjakub.rodina.bo.Mother;
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
public class MotherServiceTest extends AbstractServiceTest{
    
    @Autowired
    private MotherService ms;
    
    @Autowired
    private FatherService fs;
    
    public MotherServiceTest() {
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
     * Test of getAllMother method, of class MotherService.
     */
    @Test
    public void testGetAllMother() {
        System.out.println("getAllMother");
        ms.addMother("renata", "sutakova", new Integer(40));
        ms.addMother("petra", "ondruskova", new Integer(22));
        ms.addMother("zuzka", "hyblova", new Integer(18));
     
        assertEquals(3, ms.getAllMother().size());
    }

    /**
     * Test of getMother method, of class MotherService.
     */
    @Test
    public void testGetMother() {
        System.out.println("getMother");
        ms.addMother("renata", "sutakova", new Integer(40));
        ms.addMother("zuzana", "sutakova", new Integer(40));
        Long id = ms.addMother("marie", "sutakova", new Integer(40));
        
        List<MotherDto> mothers = ms.getMother("sutakova");
        assertEquals(3, mothers.size());
        
        MotherDto mother = ms.getMotherById(id);
        assertEquals("marie", mother.getName());
        assertEquals(mother.getName(), mothers.get(2).getName());
        
    }

    /**
     * Test of getMotherById method, of class MotherService.
     */
    @Test
    public void testGetMotherById() {
        System.out.println("getMotherById");
        Long id = ms.addMother("marie", "sutakova", new Integer(40));
        MotherDto mother = ms.getMotherById(id);
        assertEquals(id, mother.getId());
    }

    /**
     * Test of getHusband method, of class MotherService.
     */
    @Test
    public void testGetHusband() {
        System.out.println("getHusband");
        Long fatherId = fs.addFather("stanislav", "sutak", new Integer(42));
        Long motherId = ms.addMother("renata", "sutakova", new Integer(40));
        
        ms.addHusband(motherId, fatherId);
        FatherDto fDto = ms.getHusband(motherId);
        
        assertEquals(fatherId, fDto.getId());
    }
    
    /**
     * Test of addHusband method, of class MotherService.
     */
    @Test
    public void testAddHusband() {
        System.out.println("addHusband");
        Long fatherId = fs.addFather("stanislav", "sutak", new Integer(42));
        Long motherId = ms.addMother("renata", "sutakova", new Integer(40));
        
        ms.addHusband(motherId, fatherId);
        MotherDto mDto = ms.getMotherById(motherId);
        assertEquals(fatherId, mDto.getFather().getId());
    }

    /**
     * Test of addMother method, of class MotherService.
     */
    @Test
    public void testAddMother() {
        System.out.println("addMother");
        Long id1 = ms.addMother("renata", "sutakova", new Integer(40));
        Long id2 = ms.addMother("petra", "ondruskova", new Integer(20));
        
        MotherDto mother = ms.getMotherById(id1);
        assertEquals(id1, mother.getId());
        
        mother = ms.getMotherById(id2);
        assertEquals(id2, mother.getId());
    }

    /**
     * Test of editMother method, of class MotherService.
     */
    @Test
    public void testEditMother() {
        System.out.println("editMother");
        Long id = ms.addMother("renata", "sutakova", new Integer(40));
        MotherDto mother = ms.getMotherById(id);
        
        assertEquals("renata", mother.getName());
        ms.editMother(id, "jitka", "svobodova", new Integer(28));
        
        mother = ms.getMotherById(id);
        assertEquals("jitka", mother.getName());
        assertEquals("svobodova", mother.getSurname());        
    }

    /**
     * Test of deleteMother method, of class MotherService.
     */
    @Test
    public void testDeleteMother() {
        System.out.println("deleteMother");
        Long id = ms.addMother("renata", "sutakova", new Integer(40));
        
        MotherDto mother = ms.getMotherById(id);
        assertEquals(id, mother.getId());
        
        ms.deleteMother(id);
        
        mother = ms.getMotherById(id);
        assertNull(mother);
    }
}