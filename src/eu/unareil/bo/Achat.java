package eu.unareil.bo;

import java.util.ArrayList;
import java.util.List;

public class Achat {
    private Double montant;
    private List<Ligne> lignes = new ArrayList<>();

    public Achat(List<Ligne> lignes) {
        this.setLignes(lignes);
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public void setLignes(List<Ligne> lignes) {
        this.lignes = lignes;
    }

    public void getLigne(int index) {
        lignes.get(index);
    }

    public void ajouteLigne(Produit produit, int qte) {
        Ligne ligne = new Ligne(produit, qte);
        lignes.add(ligne);
    }

    public void modifieLigne(int index, int nouvelleQte) {
        Ligne ligne = lignes.get(index);
        ligne.setQuantite(nouvelleQte);
    }

    public void supprimeLigne(int index) {
        lignes.remove(index);
    }

    public void calculMontant() {
        for (Ligne ligne : lignes) {
            montant += ligne.getQuantite() * ligne.getProduit().getPrixUnitaire();
        }
    }
}
