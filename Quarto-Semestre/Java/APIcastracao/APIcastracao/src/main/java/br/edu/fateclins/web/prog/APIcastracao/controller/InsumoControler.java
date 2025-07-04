package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.InsumoDTO;
import br.edu.fateclins.web.prog.APIcastracao.module.Insumo;
import br.edu.fateclins.web.prog.APIcastracao.repository.InsumoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/insumo")
public class InsumoControler {

    @Autowired
    InsumoRepository repository;

    @PostMapping()
    public ResponseEntity<Insumo> salvarInsumo(@RequestBody InsumoDTO dto) {
        var insumoModelo = new Insumo();
        BeanUtils.copyProperties(dto, insumoModelo);
        return ResponseEntity.status(201).body(repository.save(insumoModelo));
    }

    @GetMapping()
    public ResponseEntity<List<Insumo>> getInsumo() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getInsumoById(@PathVariable(value = "id") Integer id) {
        Optional<Insumo> insumo = repository.findById(id);
        if (insumo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Insumo não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(insumo.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInsumo(@PathVariable(value = "id") Integer id,
                                               @RequestBody InsumoDTO dto) {
        Optional<Insumo> insumo = repository.findById(id);
        if (insumo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Insumo não encontrado!");
        }
        BeanUtils.copyProperties(dto, insumo.get());
        return ResponseEntity.status((HttpStatus.OK)).body(repository.save(insumo.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInsumo(@PathVariable(value = "id") Integer id) {
        Optional<Insumo> insumo = repository.findById(id);
        if (insumo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Insumo não encontrado!");
        }
        repository.delete(insumo.get());
        return ResponseEntity.status(HttpStatus.OK).body("Insumo deletado com sucesso!");
    }
}
