package com.constelis.constelis.Model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collation = "contact")
public class Contact {

    @Id
    private final String id;
    private final String lastName;
    private final String status;
    private final String email;
    private final String title;
    private final LocalDateTime reminder;
    private final String[] phones;
    private final String linkedin;
    private final ContactNeed contactNeed;
    private final List<String[]> contactPushs;
    private final List<ContactConversation> contactConversation;
    private final List<ContactInformation> contactInformation;

    public Contact(String id, String lastName, String status, String email, String title, LocalDateTime reminder,
            String[] phones, String linkedin, ContactNeed contactNeed, List<String[]> contactPushs,
            List<ContactConversation> contactConversation, List<ContactInformation> contactInformation) {
        this.id = id;
        this.lastName = lastName;
        this.status = status;
        this.email = email;
        this.title = title;
        this.reminder = reminder;
        this.phones = phones;
        this.linkedin = linkedin;
        this.contactNeed = contactNeed;
        this.contactPushs = contactPushs;
        this.contactConversation = contactConversation;
        this.contactInformation = contactInformation;
    }

}