package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.model.Cliente;
import com.proyecto.proyectoPracticoTodoCode.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements  IClienteService{

    @Autowired
    private IClienteRepository repoCli;
    @Override
    public List<Cliente> getClient() {
        return repoCli.findAll();
    }

    @Override
    public Cliente findClient(Long id_cliente) {
        return repoCli.findById(id_cliente).orElse(null);
    }

    @Override
    public void saveClient(Cliente cli) {
        repoCli.save(cli);
    }

    @Override
    public void deleteClient(Long id_cliente) {
        repoCli.deleteById(id_cliente);
    }

    @Override
    public void editClient(Cliente cli) {
        this.saveClient(cli);
    }
}
