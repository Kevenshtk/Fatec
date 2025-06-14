package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.movimentacaoDto;
import br.edu.fateclins.web.prog.APIcastracao.module.Insumo;
import br.edu.fateclins.web.prog.APIcastracao.module.Movimentacao;
import br.edu.fateclins.web.prog.APIcastracao.repository.insumoRepository;
import br.edu.fateclins.web.prog.APIcastracao.repository.movimentacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacao")
public class movimentacaoController {

    @Autowired
    movimentacaoRepository repository;

    @Autowired
    insumoRepository insumoRepository;

    @PostMapping()
    public ResponseEntity<Movimentacao> salvarMovimentacao(@RequestBody movimentacaoDto dto) {
        Optional<Insumo> insumoOpt = insumoRepository.findById(dto.insumo());
        if (insumoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(dto.data());
        movimentacao.setQdte(dto.qdte());
        movimentacao.setTipoES(dto.tipoES());
        movimentacao.setInsumo(insumoOpt.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(movimentacao));
    }

    @GetMapping()
    public ResponseEntity<List<Movimentacao>> getMovimentacao() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMovimentacaoById(@PathVariable(value = "id") Integer id) {
        Optional<Movimentacao> movimentacao = repository.findById(id);
        if (movimentacao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Movimentação não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(movimentacao.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovimentacao(@PathVariable(value = "id") Integer id,
                                                    @RequestBody movimentacaoDto dto) {
        Optional<Movimentacao> movimentacao = repository.findById(id);
        if (movimentacao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movimentação não encontrado!");
        }
        BeanUtils.copyProperties(dto, movimentacao.get());
        return ResponseEntity.status((HttpStatus.OK)).body(repository.save(movimentacao.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovimentacao(@PathVariable(value = "id") Integer id) {
        Optional<Movimentacao> movimentacao = repository.findById(id);
        if (movimentacao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movimentação não encontrado!");
        }
        repository.delete(movimentacao.get());
        return ResponseEntity.status(HttpStatus.OK).body("Movimentação deletado com sucesso!");
    }
}
