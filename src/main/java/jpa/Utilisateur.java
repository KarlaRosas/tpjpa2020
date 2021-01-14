/**Utilisateur**/
package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur {
    private Long id;

    private String name;

    private Tableau tableau;

    private List<Tableau> tableaux = new ArrayList<Tableau>();

    public Utilisateur() {
    }

    public Utilisateur(String name, Tableau tableau) {
        this.name = name;
        this.tableau = tableau;
    }

    public Utilisateur(String name) {
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

    @ManyToMany
    public List<Tableau> getTableaux() {
        return tableaux;
    }

    public void setTableaux(List<Tableau> tableaux) {
        this.tableaux = tableaux;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", name=" + name + ", tableau="
                + tableau.getName() + "]";
    }

}
