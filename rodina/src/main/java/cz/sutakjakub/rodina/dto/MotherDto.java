/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.dto;

import cz.sutakjakub.rodina.bo.Father;

/**
 *
 * @author jey
 */
public class MotherDto extends AbstractDto {

    private Father father;

    public MotherDto() {
    }

    public MotherDto(Long id, String name, String surname, Integer birth, Father father) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.father = father;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }
}
