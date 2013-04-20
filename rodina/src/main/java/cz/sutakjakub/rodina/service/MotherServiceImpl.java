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
import org.springframework.stereotype.Component;

/**
 *
 * @author jey
 */
@Component
public class MotherServiceImpl extends AbstractDataAccessService implements MotherService {

    @Override
    public List<MotherDto> getAllMother() {
        List<Mother> mothers = genericDao.getAll(Mother.class);
        List<MotherDto> mothersDto = new ArrayList<MotherDto>();
        if (mothers != null) {
            for (Mother mother : mothers) {
                mothersDto.add(createMotherDto(mother));
            }
        }
        return mothersDto;
    }

    @Override
    public List<MotherDto> getMother(String surname) {
        List<Mother> mothers = genericDao.getByProperty("surname", surname, Mother.class);
        List<MotherDto> mothersDto = new ArrayList<MotherDto>();
        if (mothers != null) {
            for (Mother mother : mothers) {
                mothersDto.add(createMotherDto(mother));
            }
        }
        return mothersDto;
    }

    @Override
    public MotherDto getMotherById(Long id) {
        Mother mother = genericDao.getById(id, Mother.class);
        if (mother != null) {
            return createMotherDto(mother);
        }
        return null;
    }

    @Override
    public FatherDto getHusband(Long id) {
//        Mother mother = genericDao.getById(id, Mother.class);
//        if(mother != null){
//            return createMotherDto(mother.getFather());
//        }
        return null;
    }

    @Override
    public Long addMother(String name, String surname, Integer birth) {
        Mother mother = new Mother();
        Long id = null;
        if (name != null && surname != null && birth != null) {
            mother.setName(name);
            mother.setSurname(surname);
            mother.setBirth(birth);
            try {
                id = genericDao.saveOrUpdate(mother).getId();
            } catch (Exception exp) {
            }
        }
        return id;
    }

    @Override
    public Long editMother(Long id, String name, String surname, Integer birth) {
        Mother mother = null;
        Long idMother = null;

        if (name != null && surname != null && birth != null) {
            try {
                mother = genericDao.getById(id, Mother.class);
                if (mother != null) {
                    mother.setName(name);
                    mother.setSurname(surname);
                    mother.setBirth(birth);
                    try {
                        idMother = genericDao.saveOrUpdate(mother).getId();
                    } catch (Exception exp) {
                    }
                }
            } catch (Exception exp) {
            }
        }
        return idMother;

    }

    @Override
    public void deleteMother(Long id) {
        if (id != null) {
            Mother mother = genericDao.getById(id, Mother.class);
            if (mother != null) {
                try {
                    genericDao.removeById(id, Mother.class);
                } catch (Exception exp) {
                }
            }
        }
    }

    @Override
    public MotherDto createMotherDto(Mother mother) {
        if (mother != null) {
            if (mother.getId() != null && mother.getName() != null
                    && mother.getSurname() != null && mother.getBirth() != null) {
                if (mother.getFather() != null) {

                    return new MotherDto(mother.getId(), mother.getName(),
                            mother.getSurname(), mother.getBirth(), mother.getFather());
                } else {
                    return new MotherDto(mother.getId(), mother.getName(),
                            mother.getSurname(), mother.getBirth(), null);
                }
            }
        }
        return null;
    }
}
