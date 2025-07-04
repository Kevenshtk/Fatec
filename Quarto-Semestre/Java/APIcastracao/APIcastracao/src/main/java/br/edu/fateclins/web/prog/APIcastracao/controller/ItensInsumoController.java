package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.ItensInsumoDTO;
import br.edu.fateclins.web.prog.APIcastracao.module.ItensInsumo;
import br.edu.fateclins.web.prog.APIcastracao.repository.ItensInsumoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itensinsumo")
public class ItensInsumoController {

    @Autowired
    ItensInsumoRepository repository;

    @PostMapping()
    public ResponseEntity<ItensInsumo> salvarItensInsumo(@RequestBody ItensInsumoDTO dto) {
        var itensInsumoModelo = new ItensInsumo();
        BeanUtils.copyProperties(dto, itensInsumoModelo);
        return ResponseEntity.status(201).body(repository.save(itensInsumoModelo));
    }

    @GetMapping()
    public ResponseEntity<List<ItensInsumo>> getItensInsumo() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItensInsumoById(@PathVariable(value = "id") Integer id) {
        Optional<ItensInsumo> istens = repository.findById(id);
        if (istens.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Itens não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(istens.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItensInsumo(@PathVariable(value = "id") Integer id,
                                                    @RequestBody ItensInsumoDTO dto) {
        Optional<ItensInsumo> itens = repository.findById(id);
        if (itens.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Itens não encontrado!");
        }
        BeanUtils.copyProperties(dto, itens.get());
        return ResponseEntity.status((HttpStatus.OK)).body(repository.save(itens.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItensInsumo(@PathVariable(value = "id") Integer id) {
        Optional<ItensInsumo> itens = repository.findById(id);
        if (itens.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Itens não encontrado!");
        }
        repository.delete(itens.get());
        return ResponseEntity.status(HttpStatus.OK).body("Itens deletado com sucesso!");
    }
}
