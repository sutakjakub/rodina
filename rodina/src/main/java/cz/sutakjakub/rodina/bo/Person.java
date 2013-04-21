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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Jakub Šuták
 */
@Entity
@Table(name = "person",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"name", "surname", "birth"}))
public class Person extends AbstractBusinessObject implements Serializable {

    private String name;
    private String surname;
    private Integer birth;
    private Set<Relations> relations = new HashSet<Relations>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person_id", cascade = CascadeType.ALL)
    public Set<Relations> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relations> relations) {
        this.relations = relations;
    }

    @Column(nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(nullable = false)
    public Integer getBirth() {
        return birth;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }
}
