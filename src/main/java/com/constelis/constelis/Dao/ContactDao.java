package com.constelis.constelis.Dao;


import com.constelis.constelis.Dao.Interface.ContactRepository;
import com.constelis.constelis.Model.Client;
import com.constelis.constelis.Model.Contact;
import com.constelis.constelis.Model.ContactConversation;
import com.constelis.constelis.Model.ContactNeed;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("ContactDao")
public class ContactDao {
    @Autowired
    private ContactRepository repository;
    private final MongoTemplate mongoTemplate;

    public ContactDao(MongoTemplate mongoTemplate){this.mongoTemplate=mongoTemplate;}


    public Contact addContact(Contact contact){
        return repository.save(contact);
    }
    public List<Contact> findAll(){
        return  repository.findAll();
    }
    public List<Contact> findByName(String firstName,String lastName){
        Query query = new Query()
                .addCriteria(Criteria.where("firstName").is(firstName))
                .addCriteria(Criteria.where("lastName").is(lastName));
        return  mongoTemplate.find(query,Contact.class);
    }

    public Contact findById(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Contact.class);
    }
    public List<ContactConversation> findConversations(String id){
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        Contact contact =  mongoTemplate.findOne(query, Contact.class);
        return contact.getContactConversation();
    }

    public List<ContactNeed> findNeed(String id){
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        Contact contact =  mongoTemplate.findOne(query, Contact.class);
        return contact.getContactNeed();
    }

    public UpdateResult addConversation(String id,ContactConversation conversation){
        List<ContactConversation> contactConversations;
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        Contact contact =  mongoTemplate.findOne(query, Contact.class);
        Update update = new Update();

        contactConversations=contact.getContactConversation();
        contactConversations.add(conversation);
        update.set("contactConversation",contactConversations);
        return mongoTemplate.updateFirst(query, update, Contact.class);
    }
    public UpdateResult addNeed(String id,ContactNeed need){
        List<ContactNeed> contactNeeds;
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        Contact contact =  mongoTemplate.findOne(query, Contact.class);
        Update update = new Update();

        contactNeeds=contact.getContactNeed();
        contactNeeds.add(need);
        update.set("contactConversation",contactNeeds);
        return mongoTemplate.updateFirst(query, update, Contact.class);
    }
    public List<Contact> findByNameStartBy(String name){
        Query query = new Query().addCriteria(Criteria.where("name").regex("^"+name));
        return mongoTemplate.find(query,Contact.class);
    }

    public Contact deleteById(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findAndRemove(query, Contact.class);
    }
    public UpdateResult updateContact(String id, Contact contact) {
        Query query = new Query().addCriteria(new Criteria().andOperator(Criteria.where("_id").is(id)));
        Update update = new Update();
        contact.StringData().forEach(update::set);
        update.set("reminder",contact.getReminder());
        update.set("contactNeed",contact.getContactNeed());
        update.set("contactPushs",contact.getContactPushs());
        update.set("contactInformation",contact.getContactInformation());
        update.set("phones",contact.getPhones());

        return mongoTemplate.updateFirst(query, update, Contact.class);
    }

}
