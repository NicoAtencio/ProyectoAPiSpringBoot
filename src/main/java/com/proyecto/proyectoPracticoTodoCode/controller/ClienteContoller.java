package com.proyecto.proyectoPracticoTodoCode.controller;

import com.proyecto.proyectoPracticoTodoCode.model.Cliente;
import com.proyecto.proyectoPracticoTodoCode.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteContoller {
    @Autowired
    private IClienteService cliService;

    @GetMapping("/clientes")
    public List<Cliente> getClients() {
        return cliService.getClient();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente findClient(@PathVariable Long id_cliente) {
        return cliService.findClient(id_cliente);
    }

    @PostMapping("/cliente/crear")
    public String createClient(@RequestBody Cliente cli) {
        cliService.saveClient(cli);
        return "Se creó con exito el cliente " + cli.getNombre() + " " + cli.getApellido();
    }

    @PutMapping("/cliente/editar")
    public Cliente editClient(@RequestBody Cliente cli) {
        cliService.editClient(cli);
        return cliService.findClient(cli.getId_cliente());
    }

    @DeleteMapping("cliente/eliminar/{idCliente}")
    public String deteleClient (@PathVariable Long idCliente) {
        cliService.deleteClient(idCliente);
        return "Se elimino con exito el usuario ";
    }
}
