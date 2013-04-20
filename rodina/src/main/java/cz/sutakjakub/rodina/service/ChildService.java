/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Mother;
import cz.sutakjakub.rodina.dto.ChildDto;
import cz.sutakjakub.rodina.dto.FatherDto;
import cz.sutakjakub.rodina.dto.MotherDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jey
 */
@Transactional
public interface ChildService {
    
    /**
     * Vrací všechny objekty Child
     * @return 
     */
    @Transactional(readOnly=true)
    public List<ChildDto> getAllChild();
    
    /**
     * Vrátí Child podle příjmení
     * @param surname
     * @return 
     */
    @Transactional(readOnly=true)
    public List<ChildDto> getChild(String surname);
            
    /**
     * Vrací Child podle jeho ID
     * @param id
     * @return 
     */
    @Transactional(readOnly=true)
    public ChildDto getChildById(Long id);
    
    /**
     * Vrací tátu
     * @param id child
     * @return 
     */
    @Transactional(readOnly=true)
    public ChildDto getFather(Long childId);
    
    /**
     * 
     * @param childId
     * @param fatherId 
     */
    @Transactional(readOnly=true)
    public void addFather(Long childId, Long fatherId);
    
     /**
     * Vrací mámu
     * @param id child
     * @return 
     */
    @Transactional(readOnly=true)
    public ChildDto getMother(Long childId);
    
    /**
     * 
     * @param childId
     * @param motherId 
     */   
    @Transactional(readOnly=true)
    public void addMother(Long childId, Long motherId);
    
    /**
     * Vrací ID uložené Child
     * @param name
     * @param surname
     * @param birth
     * @return 
     */
    @Transactional(readOnly=true)
    public Long addChild(String name, String surname, Integer birth);
    
    /**
     * Edituje Child, vrací jeho ID
     * @param id
     * @param name
     * @param surname
     * @param birth
     * @return 
     */
    @Transactional(readOnly=true)
    public Long editChild(Long id, String name, String surname, Integer birth);
    
    /**
     * Smaže Mother podle jejího ID
     * @param id 
     */
    @Transactional(readOnly=true)
    public void deleteMother(Long id);
    
    /**
     * Transformuje Mother na MotherDto
     * @param mother
     * @return 
     */
    public MotherDto createMotherDto(Mother mother);
    
}
