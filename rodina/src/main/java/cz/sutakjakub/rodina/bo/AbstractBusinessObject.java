/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Jakub Šuták
 */
// Designates a class whose mapping information is applied to the entities that 
// inherit from it. A mapped superclass has no separate table defined for it
@MappedSuperclass
public class AbstractBusinessObject {
    
    /** 
     * Indicates that the persistence provider must assign primary keys for the 
     * entity using database identity column.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    protected Long id;
    
    @Column(nullable=false)
    protected String name;
    
    @Column(nullable=false)
    protected String surname;
    
    @Column(nullable=false)
    protected Integer birth;

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

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractBusinessObject other = (AbstractBusinessObject) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
