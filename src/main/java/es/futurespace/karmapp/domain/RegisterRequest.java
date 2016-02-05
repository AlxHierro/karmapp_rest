package es.futurespace.karmapp.domain;

/**
 * Created by user on 03/02/2016.
 */
public class RegisterRequest {

    Boolean swElectric;
    Boolean swAlergies;
    Boolean pollution;
    Boolean parkings;

    public RegisterRequest(){}


    public RegisterRequest(Boolean swElectric, Boolean swAlergies, Boolean pollution, Boolean parkings) {
        this.swElectric = swElectric;
        this.swAlergies = swAlergies;
        this.pollution = pollution;
        this.parkings = parkings;
    }



    public Boolean getSwElectric() {
        return swElectric;
    }

    public void setSwElectric(Boolean swElectric) {
        this.swElectric = swElectric;
    }

    public Boolean getSwAlergies() {
        return swAlergies;
    }

    public void setSwAlergies(Boolean swAlergies) {
        this.swAlergies = swAlergies;
    }

    public Boolean getPollution() {
        return pollution;
    }

    public void setPollution(Boolean pollution) {
        this.pollution = pollution;
    }

    public Boolean getParkings() {
        return parkings;
    }

    public void setParkings(Boolean parkings) {
        this.parkings = parkings;
    }
}
