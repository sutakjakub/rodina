/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author jey
 */
@Entity
@Table(name = "personToPerson", catalog = "rodina")
@AssociationOverrides({
    @AssociationOverride(name = "pk.person1", joinColumns =
            @JoinColumn(name = "PERSON_ID1")),
    @AssociationOverride(name = "pk.person2", joinColumns =
            @JoinColumn(name = "PERSON_ID2"))})
public class PersonToPerson implements Serializable {

    private PersonType personType;
    private PersonToPersonId pk = new PersonToPersonId();

    public PersonToPerson() {
    }

    @Enumerated(EnumType.STRING)
    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    @EmbeddedId
    public PersonToPersonId getPk() {
        return pk;
    }

    public void setPk(PersonToPersonId pk) {
        this.pk = pk;
    }

    @Transient
    public Person getPerson1() {
        return getPk().getPerson1();
    }

    public void setPerson1(Person person) {
        getPk().setPerson1(person);
    }

    @Transient
    public Person getPerson2() {
        return getPk().getPerson2();
    }

    public void setPerson2(Person person) {
        getPk().setPerson2(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonToPerson that = (PersonToPerson) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
