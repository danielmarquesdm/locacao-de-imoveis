package edu.ifma.locacaodeimoveis.controller;

import edu.ifma.locacaodeimoveis.model.Imovel;
import edu.ifma.locacaodeimoveis.service.CadastroImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/imovel")
public class ImovelController {
    @Autowired
    private CadastroImovelService imovelService;

    @PostMapping("/inserir")
    public ResponseEntity<Imovel> inserir(@RequestBody @Valid Imovel imovel) {
        imovel = imovelService.inserirOuAlterar(imovel);
        return new ResponseEntity<>(imovel, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Imovel>> imoveis() {
        List<Imovel> imoveis = imovelService.buscarImoveis();
        return ResponseEntity.ok(imoveis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscaPor(Long id) {
        Imovel imovel = imovelService.buscarPor(id);
        return ResponseEntity.ok(imovel);
    }
}
