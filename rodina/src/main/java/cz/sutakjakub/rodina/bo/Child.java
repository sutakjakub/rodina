/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author jey
 */
@Entity
@Table(uniqueConstraints=
        @UniqueConstraint(columnNames={"name", "surname", "birth"}))
public class Child extends AbstractBusinessObject{
    
    /**
     * vazba *...0-1
     * Každé dítě má právě jednu mámu
     */
    @ManyToOne
    @JoinColumn(name="MOTHER_ID")
    private Mother mother;
    
    /**
     * vazba *...0-1
     * Každé dítě má jednoho nebo žádného tátu
     */
    @ManyToOne
    @JoinColumn(name="FATHER_ID")
    private Father father;
}
