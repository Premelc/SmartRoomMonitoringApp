package com.premelc.smartroommonitoringapp.DTOs.AdriaIndoorDTOs;

import org.bson.*;

public class adriaRoomAllDto {
    public Long vrijeme;
    public int zadana;
    public int izmjerena;
    public int statusKlime;
    public int brzinaPuhanja;
    public int ventil;
    public int prisutnost;
    public int prozor;
    public char modKlime;
    public int wcSet;
    public int wcMjerena;

    public Long getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Long vrijeme) {
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

    public int getModKlime() {
        return modKlime;
    }

    public void setModKlime(char modKlime) {
        this.modKlime = modKlime;
    }

    public int getWcSet() {
        return wcSet;
    }

    public void setWcSet(int wcSet) {
        this.wcSet = wcSet;
    }

    public int getWcMjerena() {
        return wcMjerena;
    }

    public void setWcMjerena(int wcMjerena) {
        this.wcMjerena = wcMjerena;
    }


    @Override
    public String toString() {
        return "adriaRoomAllDto{" +
                "vrijeme=" + vrijeme +
                ", zadana=" + zadana +
                ", izmjerena=" + izmjerena +
                ", statusKlime=" + statusKlime +
                ", brzinaPuhanja=" + brzinaPuhanja +
                ", ventil=" + ventil +
                ", prisutnost=" + prisutnost +
                ", prozor=" + prozor +
                ", modKlime=" + modKlime +
                ", wcSet=" + wcSet +
                ", wcMjerena=" + wcMjerena +
                '}';
    }

    public adriaRoomAllDto(Document data) {
        setVrijeme(Long.parseLong(data.get("vrijeme").toString()));
        setZadana(Integer.parseInt(data.get("zadana").toString()));
        setIzmjerena(Integer.parseInt(data.get("izmjerena").toString()));
        setStatusKlime(Integer.parseInt(data.get("statusKlime").toString()));
        setBrzinaPuhanja(Integer.parseInt(data.get("brzinaPuhanja").toString()));
        setVentil(Integer.parseInt(data.get("ventil").toString()));
        setPrisutnost(Integer.parseInt(data.get("prisutnost").toString()));
        setProzor(Integer.parseInt(data.get("prozor").toString()));
        setModKlime(data.get("modKlime").toString().charAt(0));
        setWcSet(Integer.parseInt(data.get("wcSet").toString()));
        setWcMjerena(Integer.parseInt(data.get("wcMjerenja").toString()));
    }
}
