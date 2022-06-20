package eu.unareil.bo;

import java.time.LocalDate;

public class Pain extends ProduitPerissable{
    private int poids;

    public Pain(long refProd, String libelle, String marque, float prixUnitaire, long qteStock, LocalDate dateLimiteConso, int poids) {
        super(refProd, libelle, marque, prixUnitaire, qteStock, dateLimiteConso);
        this.setPoids(poids);
    }

    public Pain(String libelle, String marque, float prixUnitaire, long qteStock, LocalDate dateLimiteConso, int poids) {
        super(libelle, marque, prixUnitaire, qteStock, dateLimiteConso);
        this.setPoids(poids);
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pain{");
        sb.append(", id=").append(getId());
        sb.append(", refProd=").append(getRefProd());
        sb.append(", libelle='").append(getLibelle()).append('\'');
        sb.append(", marque='").append(getMarque()).append('\'');
        sb.append(", prixUnitaire=").append(getPrixUnitaire());
        sb.append(", qteStock=").append(getQteStock());
        sb.append("poids=").append(getPoids());
        sb.append('}');
        return sb.toString();
    }
}
