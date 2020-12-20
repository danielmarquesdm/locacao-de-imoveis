package edu.ifma.locacaodeimoveis.controller;

import edu.ifma.locacaodeimoveis.model.Aluguel;
import edu.ifma.locacaodeimoveis.model.Cliente;
import edu.ifma.locacaodeimoveis.service.CadastroClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private CadastroClienteService clienteService;

    @PostMapping("/inserir")
    public ResponseEntity<Cliente> inserir(@RequestBody @Valid Cliente cliente) {
        cliente = clienteService.inserirOuAlterar(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> clientes() {
        List<Cliente> clientes = clienteService.buscarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPor(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPor(id);
        return ResponseEntity.ok(cliente);
    }

}
