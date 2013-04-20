/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Mother;
import cz.sutakjakub.rodina.dto.FatherDto;
import cz.sutakjakub.rodina.dto.MotherDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jey
 */
@Transactional
public interface MotherService {
    
    /**
     * Vrací všechny objekty Mother
     * @return 
     */
    @Transactional(readOnly=true)
    public List<MotherDto> getAllMother();
    
    /**
     * Vrátí Mother podle příjmení
     * @param surname
     * @return 
     */
    @Transactional(readOnly=true)
    public List<MotherDto> getMother(String surname);
            
    /**
     * Vrací Mother podle jejího ID
     * @param id
     * @return 
     */
    @Transactional(readOnly=true)
    public MotherDto getMotherById(Long id);
    
    /**
     * Vrací manžela
     * @param id manželky
     * @return 
     */
    @Transactional(readOnly=true)
    public FatherDto getHusband(Long id);
    
    /**
     * Vrací ID uložené Mother
     * @param name
     * @param surname
     * @param birth
     * @return 
     */
    @Transactional(readOnly=true)
    public Long addMother(String name, String surname, Integer birth);
    
    /**
     * Edituje Mother, vrací její ID
     * @param id
     * @param name
     * @param surname
     * @param birth
     * @return 
     */
    @Transactional(readOnly=true)
    public Long editMother(Long id, String name, String surname, Integer birth);
    
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
