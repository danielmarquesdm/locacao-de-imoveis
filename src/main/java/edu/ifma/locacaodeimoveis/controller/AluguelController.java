package edu.ifma.locacaodeimoveis.controller;

import edu.ifma.locacaodeimoveis.model.Aluguel;
import edu.ifma.locacaodeimoveis.service.CadastroAluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    @Autowired
    private CadastroAluguelService aluguelService;

    @PostMapping("/inserir")
    public ResponseEntity<Aluguel> inserir(@RequestBody @Valid Aluguel aluguel) {
        aluguel = aluguelService.inserirOuAlterar(aluguel);
        return new ResponseEntity<>(aluguel, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Aluguel>> alugueis() {
        List<Aluguel> alugueis = aluguelService.buscarAlugueis();
        return ResponseEntity.ok(alugueis);
    }
}
