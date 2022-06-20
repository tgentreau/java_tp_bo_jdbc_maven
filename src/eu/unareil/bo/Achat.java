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
}
