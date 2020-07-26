package com.constelis.constelis.Dao;


import com.constelis.constelis.Dao.Interface.ContactRepository;
import com.constelis.constelis.Model.Client;
import com.constelis.constelis.Model.Contact;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ContactDao")
public class ContactDao {
    @Autowired
    private ContactRepository repository;
    private MongoTemplate mongoTemplate;

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
