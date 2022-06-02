package com.premelc.smartroommonitoringapp.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.*;
import org.springframework.data.annotation.Id;

public class AdriaIndoor {

        @Id
        @BsonProperty(value = "_id")
        private ObjectId id;
        @BsonProperty(value = "vrijeme")
        private long vrijeme;
        @BsonProperty(value = "zadana")
        private int zadana;
        @BsonProperty(value = "izmjerena")
        private int izmjerena;
        @BsonProperty(value = "statusKlime")
        private int statusKlime;
        @BsonProperty(value = "brzinaPuhanja")
        private int brzinaPuhanja;
        @BsonProperty(value = "ventil")
        private int ventil;
        @BsonProperty(value = "prisutnost")
        private int prisutnost;
        @BsonProperty(value = "prozor")
        private int prozor;
        @BsonProperty(value = "modKlime")
        private String modKlime;
        @BsonProperty(value = "wcSet")
        private int wc_set;
        @BsonProperty(value = "wcMjerenja")
        private int wcMjerenja;

    public AdriaIndoor(ObjectId id, long vrijeme, int zadana, int izmjerena, int statusKlime, int brzinaPuhanja, int ventil, int prisutnost, int prozor, String modKlime, int wc_set, int wcMjerenja) {
        this.id = id;
        this.vrijeme = vrijeme;
        this.zadana = zadana;
        this.izmjerena = izmjerena;
        this.statusKlime = statusKlime;
        this.brzinaPuhanja = brzinaPuhanja;
        this.ventil = ventil;
        this.prisutnost = prisutnost;
        this.prozor = prozor;
        this.modKlime = modKlime;
        this.wc_set = wc_set;
        this.wcMjerenja = wcMjerenja;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public long getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(long vrijeme) {
        this.vrijeme = vrijeme;
    }

    public int getZadana() {
        return zadana;
    }

    public void setZadana(int zadana) {
        this.zadana = zadana;
    }

    public int getIzmjerena() {
        return izmjerena;
    }

    public void setIzmjerena(int izmjerena) {
        this.izmjerena = izmjerena;
    }

    public int getStatusKlime() {
        return statusKlime;
    }

    public void setStatusKlime(int statusKlime) {
        this.statusKlime = statusKlime;
    }

    public int getBrzinaPuhanja() {
        return brzinaPuhanja;
    }

    public void setBrzinaPuhanja(int brzinaPuhanja) {
        this.brzinaPuhanja = brzinaPuhanja;
    }

    public int getVentil() {
        return ventil;
    }

    public void setVentil(int ventil) {
        this.ventil = ventil;
    }

    public int getPrisutnost() {
        return prisutnost;
    }

    public void setPrisutnost(int prisutnost) {
        this.prisutnost = prisutnost;
    }

    public int getProzor() {
        return prozor;
    }

    public void setProzor(int prozor) {
        this.prozor = prozor;
    }

    public String getModKlime() {
        return modKlime;
    }

    public void setModKlime(String modKlime) {
        this.modKlime = modKlime;
    }

    public int getWc_set() {
        return wc_set;
    }

    public void setWc_set(int wc_set) {
        this.wc_set = wc_set;
    }

    public int getWcMjerenja() {
        return wcMjerenja;
    }

    public void setWcMjerenja(int wcMjerenja) {
        this.wcMjerenja = wcMjerenja;
    }

    @Override
    public String toString() {
        return "AdriaIndoor{" +
                "id=" + id +
                ", vrijeme=" + vrijeme +
                ", zadana=" + zadana +
                ", izmjerena=" + izmjerena +
                ", statusKlime=" + statusKlime +
                ", brzinaPuhanja=" + brzinaPuhanja +
                ", ventil=" + ventil +
                ", prisutnost=" + prisutnost +
                ", prozor=" + prozor +
                ", modKlime='" + modKlime + '\'' +
                ", wc_set=" + wc_set +
                ", wcMjerenja=" + wcMjerenja +
                '}';
    }
}

