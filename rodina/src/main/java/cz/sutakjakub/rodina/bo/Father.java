/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author jey
 */
@Entity
@Table(uniqueConstraints =
        @UniqueConstraint(columnNames = {"name", "surname", "birth"}))
public class Father extends AbstractBusinessObject {

    /**
     * vazba 0-1...0-1 Táta může mít jednu nebo žádnou manželku
     */
    @OneToOne(mappedBy = "father")
    private Mother mother;
    
    /**
     * vazba *...0-1 Každý táta nemá žádné dítě nebo neomezený počet dětí
     */
    @OneToMany(mappedBy = "father")
    private List<Child> childs;

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }
}
