/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author jey
 */
@Entity
public class Husband extends AbstractBusinessObject{
    
    @OneToOne(mappedBy="husband", cascade=CascadeType.ALL)
    private Wife wife;

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
