package eu.unareil.bo;

import java.time.LocalDate;

public class Pain extends ProduitPerissable{
    private int poids;

    public Pain(LocalDate dateLimiteConso, int poids) {
        super(dateLimiteConso);
        this.poids = poids;
    }

    public Pain(long refProd, String marque, String libelle, int poids, float prixUnitaire, long qteStock) {
        super(refProd, LocalDate.now().plusDays(2), marque, libelle, qteStock, prixUnitaire);
        this.setPoids(poids);
    }

    public Pain(String marque, String libelle, int poids, long qteStock, float prixUnitaire) {
        super(LocalDate.now().plusDays(2), marque, libelle, qteStock, prixUnitaire);
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
