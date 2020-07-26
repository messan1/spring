package com.constelis.constelis.Model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "contact")
public class Contact {

    private final String _id;
    private final String firstName;
    private final String lastName;
    private final String status;
    private final String email;
    private final String title;
    private final String linkedin;
    private final LocalDateTime reminder;
    private final String[] phones;
    private final ContactNeed contactNeed;
    private final List<String[]> contactPushs;
    private final List<ContactConversation> contactConversation;
    private final List<ContactInformation> contactInformation;

    public Contact(
            @JsonProperty("id") String _id,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("status") String status, 
            @JsonProperty("email") String email,
            @JsonProperty("title") String title, 
            @JsonProperty("reminder") LocalDateTime reminder,
            @JsonProperty("phones") String[] phones, 
            @JsonProperty("linkedin") String linkedin,
            @JsonProperty("contactNeed") ContactNeed contactNeed,
            @JsonProperty("contactPushs") List<String[]> contactPushs,
            @JsonProperty("contactConversation") List<ContactConversation> contactConversation,
            @JsonProperty("contactInformation") List<ContactInformation> contactInformation
            ) {
        this._id = _id;
        this.lastName = lastName;
        this.status = status;
        this.email = email;
        this.firstName=firstName;
        this.title = title;
        this.reminder = reminder;
        this.phones = phones;
        this.linkedin = linkedin;
        this.contactNeed = contactNeed;
        this.contactPushs = contactPushs;
        this.contactConversation = contactConversation;
        this.contactInformation = contactInformation;
    }

    public List<ContactInformation> getContactInformation() {
        return contactInformation;
    }

    public List<ContactConversation> getContactConversation() {
        return contactConversation;
    }

    public List<String[]> getContactPushs() {
        return contactPushs;
    }

    public ContactNeed getContactNeed() {
        return contactNeed;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String[] getPhones() {
        return phones;
    }

    public LocalDateTime getReminder() {
        return reminder;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public HashMap<String,String> StringData(){
        HashMap<String,String> data = new HashMap<>();
        data.put("linkedin",getLinkedin());
        data.put("status",getStatus());
        data.put("email",getEmail());
        data.put("lastName",getLastName());
        data.put("title",getTitle());
        data.put("firstName",getFirstName());
        return  data;
    }

    public String get_id() {
        return _id;
    }
}