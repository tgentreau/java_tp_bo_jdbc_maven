package eu.unareil.bo;

import java.util.ArrayList;
import java.util.List;

public class Ligne {
    private int quantite;
    private List<Produit> produits = new ArrayList<>();


    public Ligne(List<Produit> produits, int quantite) {
        this.setProduits(produits);
        this.setQuantite(quantite);
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ligne{");
        sb.append("quantite=").append(quantite);
        sb.append(", produits=").append(produits);
        sb.append('}');
        return sb.toString();
    }

}
