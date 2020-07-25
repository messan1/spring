package com.constelis.constelis.Api;

import java.util.List;

import com.constelis.constelis.Model.Client;
import com.constelis.constelis.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public List<Client> findByName() {
        return clientService.findByName();
    }

}