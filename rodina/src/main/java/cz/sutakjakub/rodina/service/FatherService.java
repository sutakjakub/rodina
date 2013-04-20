/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Father;
import cz.sutakjakub.rodina.dto.FatherDto;
import cz.sutakjakub.rodina.dto.MotherDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jey
 */
@Transactional
public interface FatherService {
    
    /**
     * Vrací všechny objekty Father
     * @return 
     */
    @Transactional(readOnly=true)
    public List<FatherDto> getAllFather();
    
    /**
     * Vrátí Father podle příjmení
     * @param surname
     * @return 
     */
    @Transactional(readOnly=true)
    public List<FatherDto> getFather(String surname);
            
    /**
     * Vrací Father podle jejího ID
     * @param id
     * @return 
     */
    @Transactional(readOnly=true)
    public FatherDto getFatherById(Long id);
    
    /**
     * Vrací manželku
     * @param id manžela
     * @return 
     */
    @Transactional(readOnly=true)
    public MotherDto getWife(Long id);
    
    /**
     * 
     * @param husbandId
     * @param wifeId 
     */
    @Transactional(readOnly=true)
    public void addWife(Long husbandId, Long wifeId);
    
    /**
     * Vrací ID uloženého Father
     * @param name
     * @param surname
     * @param birth
     * @return 
     */
    @Transactional(readOnly=true)
    public Long addFather(String name, String surname, Integer birth);
    
    /**
     * Edituje Father, vrací její ID
     * @param id
     * @param name
     * @param surname
     * @param birth
     * @return 
     */
    @Transactional(readOnly=true)
    public Long editFather(Long id, String name, String surname, Integer birth);
    
    /**
     * Smaže Father podle jejího ID
     * @param id 
     */
    @Transactional(readOnly=true)
    public void deleteFather(Long id);
    
    /**
     * Transformuje Mother na MotherDto
     * @param mother
     * @return 
     */
    public FatherDto createFatherDto(Father father);
}
