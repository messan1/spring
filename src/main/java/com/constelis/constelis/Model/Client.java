package com.constelis.constelis.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
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

}