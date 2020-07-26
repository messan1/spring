package com.constelis.constelis.Api;

import java.util.ArrayList;
import java.util.List;

import com.constelis.constelis.Model.Client;
import com.constelis.constelis.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/name")
    @ResponseBody
    public List<Client> findByName(@RequestParam(name="name") String name){
        return clientService.findByName(name);
    } 

    @PostMapping
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

}