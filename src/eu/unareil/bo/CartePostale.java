package eu.unareil.bo;

import java.util.List;

public class CartePostale extends Produit{
    private String type;

    public CartePostale(long refProd, String marque, String libelle, long qteStock, float prixUnitaire, List<Auteur> auteurs, String type) {
        super(refProd, libelle, marque, qteStock, prixUnitaire);
        this.setType(type);
    }

    public CartePostale(String marque, String libelle, long qteStock, float prixUnitaire, List<Auteur> auteurs, String type) {
        super(libelle, marque, qteStock, prixUnitaire);
        this.setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CartePostale{");
        sb.append("type='").append(getType()).append('\'');
        sb.append(", id=").append(getId());
        sb.append(", refProd=").append(getRefProd());
        sb.append(", libelle='").append(getLibelle()).append('\'');
        sb.append(", marque='").append(getMarque()).append('\'');
        sb.append(", prixUnitaire=").append(getPrixUnitaire());
        sb.append(", qteStock=").append(getQteStock());
        sb.append('}');
        return sb.toString();
    }
}
