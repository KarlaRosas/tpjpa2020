/**Employee**/
package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fiche {
    private Long id;

    private String name;

    private Tableau tableau;

    public Fiche() {
    }

    public Fiche(String name, Tableau tableau) {
        this.name = name;
        this.tableau = tableau;
    }

    public Fiche(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Tableau getTableau() {
        return tableau;
    }

    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }

    @Override
    public String toString() {
        return "Fiche [id=" + id + ", name=" + name + ", tableau="
                + tableau.getName() + "]";
    }

}
