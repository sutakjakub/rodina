/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Jakub Šuták
 */
@Entity
@Table(name = "person", catalog = "rodina",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"NAME", "SURNAME", "BIRTH"}))
public class Person extends AbstractBusinessObject implements Serializable {

    private String name;
    private String surname;
    private Integer birth;
    private Set<PersonToPerson> personToPerson = new HashSet<PersonToPerson>(0);

    public Person() {
    }

    @Column(name = "NAME", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SURNAME", nullable = false, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "BIRTH", nullable = false)
    public Integer getBirth() {
        return birth;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.person1", cascade = CascadeType.ALL)
    public Set<PersonToPerson> getPersonToPerson() {
        return personToPerson;
    }

    public void setPersonToPerson(Set<PersonToPerson> personToPerson) {
        this.personToPerson = personToPerson;
    }
}
