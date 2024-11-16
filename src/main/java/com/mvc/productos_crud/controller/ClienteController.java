package com.mvc.productos_crud.controller;

import com.mvc.productos_crud.entity.ClienteEntity;
import com.mvc.productos_crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping
    public ClienteEntity addCliente(@RequestBody ClienteEntity cliente) {
        return clienteService.addCliente(cliente);
    }

    @PutMapping("/{id}")
    public ClienteEntity updateCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}
