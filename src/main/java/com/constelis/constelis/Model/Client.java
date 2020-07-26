package com.constelis.constelis.Model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {

    @Id
    private final String id;
    private final String name;
    private final String address;
    private final String postalCode;
    private final String sector;
    private final String city;
    private final String precision;
    private final String activity;
    private final String phone1;
    private final String phone2;
    private final String email;
    private final String rights;
    private final String linkedin;
    private final String notes;

    public Client(@JsonProperty("id") String id, @JsonProperty("name") String name,
            @JsonProperty("address") String address, @JsonProperty("postalCode") String postalCode,
            @JsonProperty("sectpr") String sector, @JsonProperty("city") String city,
            @JsonProperty("precision") String precision, @JsonProperty("activity") String activity,
            @JsonProperty("phone1") String phone1, @JsonProperty("phone2") String phone2,
            @JsonProperty("email") String email, @JsonProperty("rights") String rights,
            @JsonProperty("linkedin") String linkedin, @JsonProperty("notes") String notes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.sector = sector;
        this.city = city;
        this.precision = precision;
        this.activity = activity;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.rights = rights;
        this.linkedin = linkedin;
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getRights() {
        return rights;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getActivity() {
        return activity;
    }

    public String getPrecision() {
        return precision;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public HashMap<String,String> Data(){
        HashMap<String,String> data = new HashMap<>();
        data.put("name", getName());
        data.put("notes", getNotes());
        data.put("address", getAddress());
        data.put("email", getEmail());
        data.put("postalCode", getPostalCode());
        data.put("city", getCity());
        data.put("activity", getActivity());
        data.put("precision", getPrecision());
        data.put("phone1", getPhone1());
        data.put("phone2", getPhone2());
        data.put("linkedin", getLinkedin());
        data.put("rights", getRights());

        return data;
    }
}