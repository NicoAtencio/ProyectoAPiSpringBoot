package com.proyecto.proyectoPracticoTodoCode.service;

import com.proyecto.proyectoPracticoTodoCode.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    public List<Cliente> getClient();

    public Cliente findClient(Long id_cliente);

    public  void saveClient (Cliente cli);

    public  void deleteClient(Long id_cliente);

    public void editClient(Cliente cli);
}
