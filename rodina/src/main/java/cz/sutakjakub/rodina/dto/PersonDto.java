/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.dto;

import cz.sutakjakub.rodina.bo.PersonToPerson;
import java.util.Set;

/**
 *
 * @author Jakub Šuták
 */
public class PersonDto extends AbstractDto {

    private String name;
    private String surname;
    private Integer birth;

    public PersonDto(Long id, String name, String surname, Integer birth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBirth() {
        return birth;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }
}
