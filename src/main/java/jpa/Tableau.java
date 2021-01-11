package jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
public class Tableau {

    private long id;
    private String nameTableau;
    private List<Fiche> fiches = new ArrayList<Fiche>();

    public Tableau(){
        super();
    }

    public Tableau(String nameTableau){
        this.nameTableau=nameTableau;
    }

    @Id
    @GeneratedValue
    public Long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameTableau() {
        return nameTableau;
    }

    public void setNameTableau(String nameTableau) {
        this.nameTableau = nameTableau;
    }

    @OneToMany(mappedBy = "Tableau", cascade = CascadeType.PERSIST )
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

}