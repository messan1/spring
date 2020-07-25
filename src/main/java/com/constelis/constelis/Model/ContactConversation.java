package com.constelis.constelis.Model;

import java.time.LocalDateTime;
import java.util.Date;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class ContactConversation {

    private final LocalDateTime date;
    private final String conversation;
    private final String trigramme;

    public ContactConversation(LocalDateTime date, String conversation, String trigramme) {
        this.date = date;
        this.conversation = conversation;
        this.trigramme = trigramme;
    }
    
    
}