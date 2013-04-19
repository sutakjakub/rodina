/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author jey
 */
@Entity
public class Wife extends AbstractBusinessObject{
    
    @OneToOne
    private Husband husband;
}
