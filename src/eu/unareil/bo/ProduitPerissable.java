package eu.unareil.bo;

import java.time.LocalDate;

public class ProduitPerissable extends Produit{
    private LocalDate dateLimiteConso;

    public ProduitPerissable(long refProd, String libelle, String marque, float prixUnitaire, long qteStock, LocalDate dateLimiteConso) {
        super(refProd, libelle, marque, qteStock, prixUnitaire);
        this.setDateLimiteConso(dateLimiteConso);
    }

    public ProduitPerissable(String libelle, String marque, float prixUnitaire, long qteStock, LocalDate dateLimiteConso) {
        super(libelle, marque, qteStock, prixUnitaire);
        this.setDateLimiteConso(dateLimiteConso);
    }

    public LocalDate getDateLimiteConso() {
        return dateLimiteConso;
    }

    public void setDateLimiteConso(LocalDate dateLimiteConso) {
        this.dateLimiteConso = dateLimiteConso;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProduitPerissable{");
        sb.append("id=").append(getId());
        sb.append(", refProd=").append(getRefProd());
        sb.append(", libelle='").append(getLibelle()).append('\'');
        sb.append(", marque='").append(getMarque()).append('\'');
        sb.append(", prixUnitaire=").append(getPrixUnitaire());
        sb.append(", qteStock=").append(getQteStock());
        sb.append(", dateLimiteConso=").append(getDateLimiteConso());
        sb.append('}');
        return sb.toString();
    }
}
