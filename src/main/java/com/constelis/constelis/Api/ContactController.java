package com.constelis.constelis.Api;

import com.constelis.constelis.Model.Contact;
import com.constelis.constelis.Service.ContactService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/contact")
@RestController
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
    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
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
