package edu.ifma.locacaodeimoveis.controller;

import edu.ifma.locacaodeimoveis.model.Locacao;
import edu.ifma.locacaodeimoveis.service.CadastroLocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {
    @Autowired
    private CadastroLocacaoService locacaoService;

    @PostMapping("/inserir")
    public ResponseEntity<Locacao> inserir(@RequestBody @Valid Locacao locacao) {
        locacao = locacaoService.inserirOuAlterar(locacao);
        return new ResponseEntity<>(locacao, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Locacao>> locacoes() {
        List<Locacao> locacoes = locacaoService.buscarLocacoes();
        return ResponseEntity.ok(locacoes);
    }
}
