package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.ItensInsumoDTO;
import br.edu.fateclins.web.prog.APIcastracao.Dto.ManejoDTO;
import br.edu.fateclins.web.prog.APIcastracao.module.Insumo;
import br.edu.fateclins.web.prog.APIcastracao.module.ItensInsumo;
import br.edu.fateclins.web.prog.APIcastracao.module.Manejo;
import br.edu.fateclins.web.prog.APIcastracao.repository.InsumoRepository;
import br.edu.fateclins.web.prog.APIcastracao.repository.ManejoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manejo")
public class ManejoController {

    @Autowired
    ManejoRepository repository;

    @Autowired
    private InsumoRepository insumoRepository;

    @PostMapping()
    public ResponseEntity<Manejo> salvarManejo(@RequestBody ManejoDTO dto) {
        Manejo manejo = new Manejo();
        manejo.setNome(dto.nome());
        manejo.setDescricao(dto.descricao());

        List<ItensInsumo> itens = new ArrayList<>();

        for (ItensInsumoDTO itemDTO : dto.itens()) {
            Optional<Insumo> insumoOpt = insumoRepository.findById(itemDTO.idInsumo());
            if (insumoOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);
            }

            ItensInsumo item = new ItensInsumo();
            item.setInsumo(insumoOpt.get());
            item.setQtde(itemDTO.qtde());
            item.setManejo(manejo);
            itens.add(item);
        }

        manejo.setItensInsumos(itens);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(manejo));
    }

    @GetMapping()
    public ResponseEntity<List<Manejo>> getManejo() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getManejoById(@PathVariable(value = "id") Integer id) {
        Optional<Manejo> manejo = repository.findById(id);
        if (manejo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Manejo não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(manejo.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateManejo(@PathVariable(value = "id") Integer id,
                                                    @RequestBody ManejoDTO dto) {
        Optional<Manejo> manejoOpt = repository.findById(id);
        if (manejoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manejo não encontrado!");
        }

        Manejo manejo = manejoOpt.get();
        manejo.setNome(dto.nome());
        manejo.setDescricao(dto.descricao());

        List<ItensInsumo> novosItens = new ArrayList<>();

        for (ItensInsumoDTO itemDTO : dto.itens()) {
            Optional<Insumo> insumoOpt = insumoRepository.findById(itemDTO.idInsumo());
            if (insumoOpt.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            ItensInsumo item = new ItensInsumo();
            item.setInsumo(insumoOpt.get());
            item.setQtde(itemDTO.qtde());
            item.setManejo(manejo);
            novosItens.add(item);
        }

        manejo.getItensInsumos().clear();
        manejo.getItensInsumos().addAll(novosItens);

        return ResponseEntity.ok(repository.save(manejo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteManejo(@PathVariable(value = "id") Integer id) {
        Optional<Manejo> manejo = repository.findById(id);
        if (manejo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manejo não encontrado!");
        }
        repository.delete(manejo.get());
        return ResponseEntity.status(HttpStatus.OK).body("Manejo deletado com sucesso!");
    }
}
