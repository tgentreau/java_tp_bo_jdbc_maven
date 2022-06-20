package eu.unareil.bo;

import java.util.ArrayList;
import java.util.List;

public class Auteur {
    private String nom;
    private String prenom;

    public Auteur(String nom, String prenom) {
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auteur{");
        sb.append("nom='").append(getNom()).append('\'');
        sb.append(", prenom='").append(getPrenom()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
