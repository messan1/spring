package com.constelis.constelis.Model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactInformation {
    private final String observation;
    private final String technoTools;
    private final LocalDateTime plaquette;

    public ContactInformation(String observation, String technoTools, LocalDateTime plaquette) {
        this.observation = observation;
        this.technoTools = technoTools;
        this.plaquette = plaquette;
    }
    

}