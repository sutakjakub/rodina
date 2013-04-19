/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.pres.bb;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jey
 */
@Component
@Scope(value="request")
public class AddPersonBean {
    
    private String name;
    private String surname;
    private String birth;
   

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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
    
}
