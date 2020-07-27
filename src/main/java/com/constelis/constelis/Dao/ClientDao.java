package com.constelis.constelis.Dao;


import java.util.ArrayList;
import java.util.List;
import com.constelis.constelis.Dao.Interface.ClientRepository;
import com.constelis.constelis.Model.Client;
import com.constelis.constelis.Model.Contact;
import com.mongodb.client.result.UpdateResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Repository("ClientDao")
public class ClientDao {
    @Autowired
    private ClientRepository repository;

    private final MongoTemplate mongoTemplate;

    public ClientDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public List<Client> findByName(String name) {
        Query query = new Query().addCriteria(Criteria.where("name").is("infinity"));
        return mongoTemplate.find(query, Client.class);
    }

    public Client addClient(Client client) {
        return repository.save(client);
    }

    public UpdateResult updateClient(String id, Client client) {
        Query query = new Query().addCriteria(new Criteria().andOperator(Criteria.where("_id").is(id)));
        Update update = new Update();
        client.Data().forEach(update::set);
        return mongoTemplate.updateFirst(query, update, Client.class);
    }

    public Client findById(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Client.class);
    }

    public List<Client> findByNameStartBy(String name){
        Query query = new Query().addCriteria(Criteria.where("name").regex("^"+name));
        return mongoTemplate.find(query,Client.class);
    }

    public Client deleteById(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findAndRemove(query, Client.class);
    }

    public UpdateResult addContact(String clientId,String contactId){
        Update update = new Update();
        Query contactQuery = new Query().addCriteria(Criteria.where("_id").is(contactId));
        Query clientQuery = new Query().addCriteria(Criteria.where("_id").is(clientId));
        Contact contact= mongoTemplate.findOne(contactQuery, Contact.class);
        Client client = mongoTemplate.findOne(clientQuery,Client.class);
        List<Contact>  contacts = client.getContacts();
        contacts.add(contact);
        update.set("contacts",contacts);

        return  mongoTemplate.updateFirst(clientQuery, update, Client.class);
    }
}
