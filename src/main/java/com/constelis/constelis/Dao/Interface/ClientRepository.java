package com.constelis.constelis.Dao.Interface;

import java.util.List;

import com.constelis.constelis.Model.Client;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,String>{
    public List<Client> findAll();
    public Client findByName(String name);
    public Client findByContactName(String name);
    public List<Client> findByReminder(String date);
    public List<Client> findByContactPush(String name);
    public List<Client> findByNeeds(String nedds);
    public Client updateInformation(Client client);
    public int deleteClient(String id);
}