package eu.unareil.bo;

import java.time.LocalDate;

public class ProduitPerissable extends Produit{
    private LocalDate dateLimiteConso;

    public ProduitPerissable(LocalDate dateLimiteConso) {
        this.dateLimiteConso = dateLimiteConso;
    }

    public ProduitPerissable(long refProd, LocalDate dateLimiteConso, String marque, String libelle,  long qteStock, float prixUnitaire) {
        super(refProd, marque, libelle, qteStock, prixUnitaire);
        this.setDateLimiteConso(dateLimiteConso);
    }

    public ProduitPerissable(LocalDate dateLimiteConso, String marque, String libelle, long qteStock, float prixUnitaire) {
        super(marque, libelle, qteStock, prixUnitaire);
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
