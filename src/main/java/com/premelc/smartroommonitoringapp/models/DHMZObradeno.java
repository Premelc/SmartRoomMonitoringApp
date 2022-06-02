package com.premelc.smartroommonitoringapp.models;

import org.springframework.data.annotation.*;

public class DHMZObradeno {

    @Id
    private String _id;
    private long vrijeme;
    private Double zracenje;
    private Double temperatura;
    private Double smjerVjetra;
    private Double brzinaVjetra;
    private Double vlaznost;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public long getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(long vrijeme) {
        this.vrijeme = vrijeme;
    }

    public Double getZracenje() {
        return zracenje;
    }

    public void setZracenje(Double zracenje) {
        this.zracenje = zracenje;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getSmjerVjetra() {
        return this.smjerVjetra ;
    }

    public void setSmjerVjetra(Double smjerVjetra) {
        this.smjerVjetra =smjerVjetra;
    }

    public Double getBrzinaVjetra() {
        return brzinaVjetra;
    }

    public void setBrzinaVjetra(Double brzinaVjetra) {
        this.brzinaVjetra = brzinaVjetra;
    }

    public Double getRelativnaVlaznost() {
        return vlaznost;
    }

    public void setRelativnaVlaznost(Double relativnaVlaznost) {
        this.vlaznost = relativnaVlaznost;
    }

    public DHMZObradeno(String _id, Double zracenje, Double temperatura, Double smjerVjetra, Double brzinaVjetra, Double vlaznost) {
        this._id = _id;
        this.zracenje = zracenje;
        this.temperatura = temperatura;
        this.smjerVjetra = smjerVjetra;
        this.brzinaVjetra = brzinaVjetra;
        this.vlaznost = vlaznost;
    }


}
