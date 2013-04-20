/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sutakjakub.rodina.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author jey
 */
@Entity
@Table(uniqueConstraints=
        @UniqueConstraint(columnNames={"name", "surname", "birth"}))
public class Mother extends AbstractBusinessObject{
    
    /**
     * vazba 0-1...0-1
     * Máma může mít jednoho nebo žádného manžela 
     */
    @OneToOne
    @JoinColumn(name="FATHER_ID")
    private Father father;
    
    /**
     * vazba *...0-1 
     * Máma nemá žádné dítě nebo neomezený počet dětí
     */
    @OneToMany(mappedBy = "mother")
    private List<Child> childs;

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }
       
    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }
}
