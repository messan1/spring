package com.constelis.constelis.Dao;
import java.util.List;
import com.constelis.constelis.Dao.Interface.ClientRepository;
import com.constelis.constelis.Model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("ClientDao")
public class ClientDao {
    @Autowired
    private ClientRepository repository;


    public List<Client> findByName() {
        return repository.findAll();
    }
}