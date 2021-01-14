/**Tableau*/
package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Tableau {

    private Long id;

    private String name;

    private List<Fiche> fiches = new ArrayList<Fiche>();

    private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

    private List<Section> sections = new ArrayList<Section>();

    public Tableau() {
        super();
    }

    public Tableau(String name) {
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

    @OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Employee> employees) {
        this.fiches = fiches;
    }

    @ManyToMany(mappedBy = "tableaux", cascade = CascadeType.PERSIST)
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}



