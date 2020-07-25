package com.constelis.constelis.Model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
public class Contact {
    
    @Id
    private final String id;
    private final String lastName;
    private final String status;
    private final String email;
    private final String title;
    private final Date reminder;
    private final String[] phones;
    private final String linkedin;
    private final String observation;
    private final String technoTools;
    private final Date plaquette;

    public Contact(String id, String lastName, String status, String email, String title, Date reminder,
            String[] phones, String linkedin, String observation, String technoTools, Date plaquette) {
        this.id = id;
        this.lastName = lastName;
        this.status = status;
        this.email = email;
        this.title = title;
        this.reminder = reminder;
        this.phones = phones;
        this.linkedin = linkedin;
        this.observation = observation;
        this.technoTools = technoTools;
        this.plaquette = plaquette;
    }
    
}