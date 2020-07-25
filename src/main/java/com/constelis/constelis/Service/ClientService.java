package com.constelis.constelis.Service;

import java.util.List;

import com.constelis.constelis.Dao.ClientDao;
import com.constelis.constelis.Model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    @Autowired
    private ClientDao clientDao;

    public ClientService(@Qualifier("ClientDao") ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> findByName(){
        return clientDao.findByName();
    }
}