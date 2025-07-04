package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.ItensManejoDTO;
import br.edu.fateclins.web.prog.APIcastracao.module.ItensManejo;
import br.edu.fateclins.web.prog.APIcastracao.repository.IntensManejoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itensmanejo")
public class ItensManejoController {

    @Autowired
    IntensManejoRepository repository;

    @PostMapping()
    public ResponseEntity<ItensManejo> salvarItensManejo(@RequestBody ItensManejoDTO dto) {
        var itensManejoModelo = new ItensManejo();
        BeanUtils.copyProperties(dto, itensManejoModelo);
        return ResponseEntity.status(201).body(repository.save(itensManejoModelo));
    }

    @GetMapping()
    public ResponseEntity<List<ItensManejo>> getItensManejo() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItensManejoById(@PathVariable(value = "id") Integer id) {
        Optional<ItensManejo> istens = repository.findById(id);
        if (istens.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Itens não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(istens.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItensManejo(@PathVariable(value = "id") Integer id,
                                               @RequestBody ItensManejoDTO dto) {
        Optional<ItensManejo> itens = repository.findById(id);
        if (itens.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Itens não encontrado!");
        }
        BeanUtils.copyProperties(dto, itens.get());
        return ResponseEntity.status((HttpStatus.OK)).body(repository.save(itens.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItensManejo(@PathVariable(value = "id") Integer id) {
        Optional<ItensManejo> itens = repository.findById(id);
        if (itens.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Itens não encontrado!");
        }
        repository.delete(itens.get());
        return ResponseEntity.status(HttpStatus.OK).body("Itens deletado com sucesso!");
    }
}
