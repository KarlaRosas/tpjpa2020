package jpa;
import com.sun.javafx.binding.StringFormatter;
import javafx.scene.control.Tab;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.ManyToAny;

@Entity
public class Fiche {


    private long id;

    private String libelle;
    private Tableau tableau;
    private Date dateButoire;
    private Utilisateur utilisateur;
    private Time besoinMinutes;
    private List<Tags> tags;
    private String lieu;
    private  String url;



    public Fiche(){
     //  super();
   }

   public Fiche(String libelle){
       this.libelle = libelle;
   }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateButoire() {
        return dateButoire;
    }

    public void setDateButoire(Date dateButoire) {
        this.dateButoire = dateButoire;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Time getBesoinMinutes() {
        return besoinMinutes;
    }

    public void setBesoinMinutes(Time besoinMinutes) {
        this.besoinMinutes = besoinMinutes;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne
    public Tableau getTableau() {
        return tableau;
    }

    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }

}




