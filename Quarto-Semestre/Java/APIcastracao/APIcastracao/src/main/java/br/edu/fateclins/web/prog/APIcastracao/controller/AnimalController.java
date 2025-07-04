package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.AnimalDTO;
import br.edu.fateclins.web.prog.APIcastracao.module.Animal;
import br.edu.fateclins.web.prog.APIcastracao.repository.AnimalRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalRespository respository;

    @PostMapping()
    public ResponseEntity<Animal> salvarAnimal(@RequestBody AnimalDTO dto) {
        var animalModelo = new Animal();
        BeanUtils.copyProperties(dto, animalModelo);
        return ResponseEntity.status(201).body(respository.save(animalModelo));
    }

    @GetMapping()
    public ResponseEntity<List<Animal>> getAnimal() {
        return ResponseEntity.status(HttpStatus.OK).body(respository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAnimalById(@PathVariable(value = "id") Integer id) {
        Optional<Animal> produto = respository.findById(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Animal não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAnimal(@PathVariable(value = "id") Integer id,
                                               @RequestBody AnimalDTO dto) {
        Optional<Animal> produto = respository.findById(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal não encontrado!");
        }
        BeanUtils.copyProperties(dto, produto.get());
        return ResponseEntity.status((HttpStatus.OK)).body(respository.save(produto.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAnimal(@PathVariable(value = "id") Integer id) {
        Optional<Animal> animal = respository.findById(id);
        if (animal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal não encontrado!");
        }
        respository.delete(animal.get());
        return ResponseEntity.status(HttpStatus.OK).body("Animal deletado com sucesso!");
    }
}
