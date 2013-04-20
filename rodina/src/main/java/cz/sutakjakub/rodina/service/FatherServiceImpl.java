/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.service;

import cz.sutakjakub.rodina.bo.Father;
import cz.sutakjakub.rodina.bo.Mother;
import cz.sutakjakub.rodina.dto.FatherDto;
import cz.sutakjakub.rodina.dto.MotherDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jey
 */
@Component
public class FatherServiceImpl extends AbstractDataAccessService implements FatherService{

    @Autowired
    private MotherService ms;
    
    @Override
    public List<FatherDto> getAllFather() {
        List<Father> fathers = genericDao.getAll(Father.class);
        List<FatherDto> fathersDto = new ArrayList<FatherDto>();
        if (fathers != null) {
            for (Father father : fathers) {
                fathersDto.add(createFatherDto(father));
            }
        }
        return fathersDto;
    }

    @Override
    public List<FatherDto> getFather(String surname) {
        List<Father> fathers = genericDao.getByProperty("surname", surname, Father.class);
        List<FatherDto> fathersDto = new ArrayList<FatherDto>();
        if (fathers != null) {
            for (Father father : fathers) {
                fathersDto.add(createFatherDto(father));
            }
        }
        return fathersDto;
    }

    @Override
    public FatherDto getFatherById(Long id) {
        Father father = genericDao.getById(id, Father.class);
        if (father != null) {
            return createFatherDto(father);
        }
        return null;
    }

    @Override
    public MotherDto getWife(Long id) {
        Father father = genericDao.getById(id, Father.class);
        MotherDto mother = null;
        if(father != null){
            mother = ms.createMotherDto(father.getMother());
        }
        return mother;
    }
    
    @Override
    public void addWife(Long husbandId, Long wifeId) {
        Father father = genericDao.getById(husbandId, Father.class);
        Mother mother = genericDao.getById(wifeId, Mother.class);
        if (father != null && mother != null) {
            try {
                father.setMother(mother);
            } catch (Exception exp) {
            }
        }
    }

    @Override
    public Long addFather(String name, String surname, Integer birth) {
        Father father = new Father();
        Long id = null;
        if (name != null && surname != null && birth != null) {
            father.setName(name);
            father.setSurname(surname);
            father.setBirth(birth);
            try {
                id = genericDao.saveOrUpdate(father).getId();
            } catch (Exception exp) {
            }
        }
        return id;
    }

    @Override
    public Long editFather(Long id, String name, String surname, Integer birth) {
        Father father = null;
        Long idFather = null;

        if (name != null && surname != null && birth != null) {
            try {
                father = genericDao.getById(id, Father.class);
                if (father != null) {
                    father.setName(name);
                    father.setSurname(surname);
                    father.setBirth(birth);
                    try {
                        idFather = genericDao.saveOrUpdate(father).getId();
                    } catch (Exception exp) {
                    }
                }
            } catch (Exception exp) {
            }
        }
        return idFather;
    }

    @Override
    public void deleteFather(Long id) {
         if (id != null) {
            Father father = genericDao.getById(id, Father.class);
            if (father != null) {
                try {
                    genericDao.removeById(id, Father.class);
                } catch (Exception exp) {
                }
            }
        }
    }

    @Override
    public FatherDto createFatherDto(Father father) {
        if (father != null) {
            if (father.getId() != null && father.getName() != null
                    && father.getSurname() != null && father.getBirth() != null) {
                if (father.getMother() != null) {

                    return new FatherDto(father.getId(), father.getName(),
                            father.getSurname(), father.getBirth(), father.getMother());
                } else {
                    return new FatherDto(father.getId(), father.getName(),
                            father.getSurname(), father.getBirth(), null);
                }
            }
        }
        return null;
    }

    
    
}
