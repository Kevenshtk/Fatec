package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.tutorDto;
import br.edu.fateclins.web.prog.APIcastracao.module.Tutor;
import br.edu.fateclins.web.prog.APIcastracao.repository.tutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutor")
public class tutorController {

    @Autowired
    tutorRepository repository;

    @PostMapping()
    public ResponseEntity<Tutor> salvarTutor(@RequestBody tutorDto dto) {
        var tutorModelo = new Tutor();
        BeanUtils.copyProperties(dto, tutorModelo);
        return ResponseEntity.status(201).body(repository.save(tutorModelo));
    }

    @GetMapping()
    public ResponseEntity<List<Tutor>> getTutor() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTutorById(@PathVariable(value = "id") Integer id) {
        Optional<Tutor> tutor = repository.findById(id);
        if (tutor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tutor não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tutor.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTutor(@PathVariable(value = "id") Integer id,
                                               @RequestBody tutorDto dto) {
        Optional<Tutor> tutor = repository.findById(id);
        if (tutor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutor não encontrado!");
        }
        BeanUtils.copyProperties(dto, tutor.get());
        return ResponseEntity.status((HttpStatus.OK)).body(repository.save(tutor.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTutor(@PathVariable(value = "id") Integer id) {
        Optional<Tutor> tutor = repository.findById(id);
        if (tutor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutor não encontrado!");
        }
        repository.delete(tutor.get());
        return ResponseEntity.status(HttpStatus.OK).body("Tutor deletado com sucesso!");
    }
}
