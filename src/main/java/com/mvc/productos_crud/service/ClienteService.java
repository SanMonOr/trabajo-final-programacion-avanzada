package com.mvc.productos_crud.service;

import com.mvc.productos_crud.entity.ClienteEntity;
import com.mvc.productos_crud.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> getAllClientes() {
        return clienteRepository.findAll();
    }

    public ClienteEntity addCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public ClienteEntity updateCliente(Long id, ClienteEntity cliente) {
        Optional<ClienteEntity> existingCliente = clienteRepository.findById(id);
        if (existingCliente.isPresent()) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
