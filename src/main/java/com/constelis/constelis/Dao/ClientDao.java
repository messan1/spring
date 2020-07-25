package com.constelis.constelis.Dao;
import java.util.List;
import com.constelis.constelis.Dao.Interface.ClientRepository;
import com.constelis.constelis.Model.Client;

import org.springframework.stereotype.Repository;



@Repository("MongoDB")
public class ClientDao {
    private ClientRepository repository;


    public List<Client> findAll() {
        return repository.findAll();
    }
}