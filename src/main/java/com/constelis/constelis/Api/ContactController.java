package com.constelis.constelis.Api;

import com.constelis.constelis.Model.Contact;
import com.constelis.constelis.Model.ContactConversation;
import com.constelis.constelis.Model.ContactNeed;
import com.constelis.constelis.Service.ContactService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/contact")
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    private List<Contact> findAll(){
        return contactService.findAll();
    }
    @GetMapping("/name")
    private List<Contact> findByName(@RequestParam(name="firstName") String firstName,@RequestParam(name = "lastName") String lastName){
        return contactService.findByName(firstName,lastName);
    }
    @GetMapping("/conversation")
    private List<ContactConversation> findConversations(@RequestParam(name="id") String id){
        return contactService.findConversations(id);
    }
    @GetMapping("/need")
    private List<ContactNeed> findNeed(@RequestParam(name="id") String id){
        return contactService.findNeed(id);
    }
    @GetMapping("/startby")
    private List<Contact> findByNameStartBy(@RequestParam(name = "name") String name){
        return null;
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @PostMapping("/conversation")
    public UpdateResult addConversation(@RequestParam(name="id") String id,@RequestBody ContactConversation conversation) {
        return contactService.addConversation(id,conversation);
    }
    @PostMapping("/need")
    public UpdateResult addNeed(@RequestParam(name="id") String id,@RequestBody ContactNeed contactNeed) {
        return contactService.addNeed(id,contactNeed);
    }
    @PutMapping
    public UpdateResult updateContact(@RequestParam(name = "id") String id, @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }

    @DeleteMapping
    public Contact deleteById(@RequestParam(name = "id") String id) {
        return contactService.deleteById(id);
    }

}
