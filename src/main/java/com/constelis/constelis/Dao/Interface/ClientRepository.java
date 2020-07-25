package com.constelis.constelis.Dao.Interface;
import java.util.List;

import com.constelis.constelis.Model.Client;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,Integer>{
    
}