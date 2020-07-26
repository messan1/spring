package com.constelis.constelis.Dao;


import java.util.List;
import com.constelis.constelis.Dao.Interface.ClientRepository;
import com.constelis.constelis.Model.Client;
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
    private MongoTemplate mongoTemplate;

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
        client.Data().forEach((key, value) -> update.set(key, value));
        return mongoTemplate.updateFirst(query, update, Client.class);
    }

    public Client findById(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Client.class);
    }

    public Client deleteById(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findAndRemove(query, Client.class);
    }
}