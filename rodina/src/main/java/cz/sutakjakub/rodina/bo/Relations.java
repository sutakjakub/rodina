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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author jey
 */
@Entity
@Table(name = "relations")
@AssociationOverrides({
    @AssociationOverride(name = "pk.person", joinColumns =
            @JoinColumn(name = "PERSON1_ID")),
    @AssociationOverride(name = "pk.person", joinColumns =
            @JoinColumn(name = "PERSON2_ID"))
})
public class Relations implements Serializable {

    private PersonType personType;
    private RelationsId pk = new RelationsId();

    public Relations() {
    }

    @Enumerated(EnumType.STRING)
    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    @EmbeddedId
    public RelationsId getPk() {
        return pk;
    }

    public void setPk(RelationsId pk) {
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
}
