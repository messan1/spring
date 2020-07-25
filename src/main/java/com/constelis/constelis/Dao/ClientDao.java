package com.constelis.constelis.Dao;
import java.util.List;
import com.constelis.constelis.Dao.Interface.ClientRepository;
import com.constelis.constelis.Model.Client;


public class ClientDao {
    private ClientRepository repository;


    public List<Client> findAll() {
        return repository.findAll();
    }
}