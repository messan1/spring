package com.constelis.constelis.Dao.Interface;
import java.util.List;

import com.constelis.constelis.Model.Client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ClientRepository extends MongoRepository<Client,Integer>{

    @Query("{'name': {$regex: '^i.*'} }")
    List<Client> findByName(String name);
}