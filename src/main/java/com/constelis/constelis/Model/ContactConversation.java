package com.constelis.constelis.Model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class ContactConversation {

    @Id
    private final String id;
    private final Date date;
    private final String conversation;
    private final String trigramme;

    public ContactConversation(String id, Date date, String conversation, String trigramme) {
        this.id = id;
        this.date = date;
        this.conversation = conversation;
        this.trigramme = trigramme;
    }
    
    
}