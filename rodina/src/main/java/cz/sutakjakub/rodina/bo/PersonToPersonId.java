/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author jey
 */
@Embeddable
public class PersonToPersonId implements Serializable {

    private Person person1;
    private Person person2;

    @ManyToOne
    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    @ManyToOne
    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }
    
@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonToPersonId that = (PersonToPersonId) o;

        if (person1 != null ? !person1.equals(that.person1) : that.person1 != null) return false;
        if (person2 != null ? !person2.equals(that.person2) : that.person2 != null)
            return false;

        return true;
    }

        @Override
    public int hashCode() {
        int result;
        result = (person1 != null ? person1.hashCode() : 0);
        result = 31 * result + (person2 != null ? person2.hashCode() : 0);
        return result;
    }
}
