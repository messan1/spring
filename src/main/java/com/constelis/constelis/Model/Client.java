package com.constelis.constelis.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class Client {
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

    public Client(String name, String address, String postalCode, String sector, String city, String precision,
            String activity, String phone1, String phone2, String email, String rights, String linkedin, String notes) {
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