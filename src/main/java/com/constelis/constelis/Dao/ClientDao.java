package com.constelis.constelis.Dao;
import java.util.List;
import com.constelis.constelis.Dao.Interface.ClientRepository;
import com.constelis.constelis.Model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


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
    public List<Client> findByName(String name){
        Query query = new Query()
        .addCriteria(Criteria.where("name").is("infinity"));
        return mongoTemplate.find(query,Client.class);
    }

    public Client addClient(Client client){
        return repository.save(client);
    }


}