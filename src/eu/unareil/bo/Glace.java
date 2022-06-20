package eu.unareil.bo;

import java.time.LocalDate;

public class Glace extends ProduitPerissable{
    private String parfum;
    private int temperatureConservation;

    public Glace(long refProd, String libelle, String marque, float prixUnitaire, long qteStock, LocalDate dateLimiteConso, String parfum, int temperatureConservation) {
        super(refProd, libelle, marque, prixUnitaire, qteStock, dateLimiteConso);
        this.setParfum(parfum);
        this.setTemperatureConservation(temperatureConservation);
    }

    public Glace(String libelle, String marque, float prixUnitaire, long qteStock, LocalDate dateLimiteConso, String parfum, int temperatureConservation) {
        super(libelle, marque, prixUnitaire, qteStock, dateLimiteConso);
        this.setParfum(parfum);
        this.setTemperatureConservation(temperatureConservation);
    }

    public String getParfum() {
        return parfum;
    }

    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public int getTemperatureConservation() {
        return temperatureConservation;
    }

    public void setTemperatureConservation(int temperatureConservation) {
        this.temperatureConservation = temperatureConservation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Glace{");
        sb.append(", id=").append(getId());
        sb.append(", refProd=").append(getRefProd());
        sb.append(", libelle='").append(getLibelle()).append('\'');
        sb.append(", marque='").append(getMarque()).append('\'');
        sb.append(", prixUnitaire=").append(getPrixUnitaire());
        sb.append(", qteStock=").append(getQteStock());
        sb.append("parfum='").append(getParfum()).append('\'');
        sb.append(", temperatureConservation=").append(getTemperatureConservation());
        sb.append('}');
        return sb.toString();
    }
}
