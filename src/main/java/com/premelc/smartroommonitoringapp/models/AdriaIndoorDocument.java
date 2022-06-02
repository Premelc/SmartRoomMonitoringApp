package com.premelc.smartroommonitoringapp.models;


import org.bson.Document;

public class AdriaIndoorDocument {
    public static Document createDoc(AdriaIndoor data){
        Document doc = new Document("_id" , data.getId());
        doc.append("vrijeme" , data.getVrijeme())
                .append("zadana" , data.getZadana())
                .append("izmjerena" ,data.getIzmjerena())
                .append("statusKlime" , data.getStatusKlime())
                .append("brzinaPuhanja" ,data.getBrzinaPuhanja())
                .append("ventil" , data.getVentil())
                .append("prisutnost" , data.getPrisutnost())
                .append("prozor" ,data.getProzor())
                .append("modKlime" , data.getModKlime())
                .append("wcSet" , data.getWc_set())
                .append("wcMjerenja" , data.getWcMjerenja())
                .append("_class" , "com.premelc.smartroommonitoringapp.models.AdriaIndoor");
        return doc;
    }
}
