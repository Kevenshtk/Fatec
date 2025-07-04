package br.edu.fateclins.web.prog.APIcastracao.controller;

import br.edu.fateclins.web.prog.APIcastracao.Dto.ItensManejoDTO;
import br.edu.fateclins.web.prog.APIcastracao.Dto.AgendamentoDTO;
import br.edu.fateclins.web.prog.APIcastracao.module.*;
import br.edu.fateclins.web.prog.APIcastracao.repository.AgendamentoRepository;
import br.edu.fateclins.web.prog.APIcastracao.repository.AnimalRespository;
import br.edu.fateclins.web.prog.APIcastracao.repository.ManejoRepository;
import br.edu.fateclins.web.prog.APIcastracao.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoRepository repository;

    @Autowired
    private ManejoRepository manejoRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private AnimalRespository animalRepository;

    @PostMapping()
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody AgendamentoDTO dto) {
        var agendamento = new Agendamento();
        agendamento.setDataPrevista(dto.dataPrevista());
        agendamento.setObservacao(dto.observacao());

        Optional<Responsavel> responsavelOpt = responsavelRepository.findById(dto.idResponsavel());
        if (responsavelOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        agendamento.setResponsavel(responsavelOpt.get());

        Optional<Animal> animalOpt = animalRepository.findById(dto.idAnimal());
        if (animalOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        agendamento.setAnimal(animalOpt.get());

        List<ItensManejo> itens = new ArrayList<>();

        for (ItensManejoDTO itemDTO : dto.itens()) {
            Optional<Manejo> manejoOpt = manejoRepository.findById(itemDTO.idManejo());
            if (manejoOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);
            }

            ItensManejo item = new ItensManejo();
            item.setManejo(manejoOpt.get());
            item.setQtde(itemDTO.qtde());
            item.setAgendamento(agendamento);
            itens.add(item);
        }

        agendamento.setItensManejo(itens);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(agendamento));
    }

    @GetMapping()
    public ResponseEntity<List<Agendamento>> getAgendamento() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAgendamentoById(@PathVariable(value = "id") Integer id) {
        Optional<Agendamento> agendamento = repository.findById(id);
        if (agendamento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Agendamento não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(agendamento.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAgendamento(@PathVariable(value = "id") Integer id,
                                               @RequestBody AgendamentoDTO dto) {
        Optional<Agendamento> agendamentoOpt = repository.findById(id);
        if (agendamentoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado!");
        }

        Agendamento agendamento = agendamentoOpt.get();
        agendamento.setDataPrevista(dto.dataPrevista());
        agendamento.setObservacao(dto.observacao());

        Optional<Responsavel> responsavelOpt = responsavelRepository.findById(dto.idResponsavel());
        if (responsavelOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        agendamento.setResponsavel(responsavelOpt.get());

        Optional<Animal> animalOpt = animalRepository.findById(dto.idAnimal());
        if (animalOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        agendamento.setAnimal(animalOpt.get());

        List<ItensManejo> novosItens = new ArrayList<>();

        for (ItensManejoDTO itemDTO : dto.itens()) {
            Optional<Manejo> manejoOpt = manejoRepository.findById(itemDTO.idManejo());
            if (manejoOpt.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            ItensManejo item = new ItensManejo();
            item.setManejo(manejoOpt.get());
            item.setQtde(itemDTO.qtde());
            item.setAgendamento(agendamento);
            novosItens.add(item);
        }

        agendamento.getItensManejo().clear();
        agendamento.getItensManejo().addAll(novosItens);

        return ResponseEntity.ok(repository.save(agendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAgendamento(@PathVariable(value = "id") Integer id) {
        Optional<Agendamento> agendamento = repository.findById(id);
        if (agendamento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado!");
        }
        repository.delete(agendamento.get());
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento deletado com sucesso!");
    }
}
