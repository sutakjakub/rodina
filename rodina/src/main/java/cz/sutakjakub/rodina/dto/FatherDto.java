/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.dto;

import cz.sutakjakub.rodina.bo.Child;
import cz.sutakjakub.rodina.bo.Mother;
import java.util.List;

/**
 *
 * @author jey
 */
public class FatherDto extends AbstractDto {

    private Mother mother;
    private List<Child> childs;

    public FatherDto() {
    }

    public FatherDto(Long id, String name, String surname, Integer birth, Mother mother) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.mother = mother;
    }   

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }
}
