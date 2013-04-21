/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import cz.sutakjakub.rodina.bo.Person;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Jakub Šuták
 */
@Entity
@Table(name = "tbl_persons",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"name", "surname", "birth"}))
public class Person extends AbstractBusinessObject{
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String surname;
    
    @Column(nullable = false)
    private Integer birth;
    
    @Column(name = "PERSON_TYPE")
    @Enumerated(EnumType.STRING)
    private PersonType personType;
    
    @ManyToMany(
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity=Person.class)
    @JoinTable(name = "tbl_relations",
            joinColumns =
            @JoinColumn(name = "personsId"),
            inverseJoinColumns =
            @JoinColumn(name = "relativeId"))
    private List<Person> persons;
    
    @ManyToMany(
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity=Person.class)
    @JoinTable(name = "tbl_relations",
            joinColumns =
            @JoinColumn(name = "relativeId"),
            inverseJoinColumns =
            @JoinColumn(name = "personsId"))
    private List<Person> relative;  

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

    public Integer getBirth() {
        return birth;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getRelative() {
        return relative;
    }

    public void setRelative(List<Person> relative) {
        this.relative = relative;
    }

}
