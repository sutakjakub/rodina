/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.dto;

import cz.sutakjakub.rodina.bo.Father;
import cz.sutakjakub.rodina.bo.Mother;

/**
 *
 * @author jey
 */
public class ChildDto extends AbstractDto {
    
    private Mother mother;
    private Father father;

    public ChildDto() {
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }
}
