package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.responsavelDto;
import br.edu.fateclins.web.prog.APIcastracao.module.Responsavel;
import br.edu.fateclins.web.prog.APIcastracao.repository.responsavelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsavel")
public class responsavelController {

    @Autowired
    responsavelRepository repository;

    @PostMapping()
    public ResponseEntity<Responsavel> salvarResponsavel(@RequestBody responsavelDto dto) {
        var responsavelModelo = new Responsavel();
        BeanUtils.copyProperties(dto, responsavelModelo);
        return ResponseEntity.status(201).body(repository.save(responsavelModelo));
    }

    @GetMapping()
    public ResponseEntity<List<Responsavel>> getResponsavel() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getResponsavelById(@PathVariable(value = "id") Integer id) {
        Optional<Responsavel> responsavel = repository.findById(id);
        if (responsavel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsavel não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(responsavel.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateResponsavel(@PathVariable(value = "id") Integer id,
                                                     @RequestBody responsavelDto dto) {
        Optional<Responsavel> responsavel = repository.findById(id);
        if (responsavel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsavel não encontrado!");
        }
        BeanUtils.copyProperties(dto, responsavel.get());
        return ResponseEntity.status((HttpStatus.OK)).body(repository.save(responsavel.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteResponsavel(@PathVariable(value = "id") Integer id) {
        Optional<Responsavel> responsavel = repository.findById(id);
        if (responsavel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsavel não encontrado!");
        }
        repository.delete(responsavel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Responsavel deletado com sucesso!");
    }

}
