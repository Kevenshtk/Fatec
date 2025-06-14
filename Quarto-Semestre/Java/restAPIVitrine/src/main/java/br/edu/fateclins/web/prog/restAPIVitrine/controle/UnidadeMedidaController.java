package br.edu.fateclins.web.prog.restAPIVitrine.controle;

import br.edu.fateclins.web.prog.restAPIVitrine.dto.UnidadeMedidaDTO;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.UnidadeMedida;
import br.edu.fateclins.web.prog.restAPIVitrine.repository.UnidadeMedidaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UnidadeMedidaController {

    @Autowired
    UnidadeMedidaRepository repositorioUnidadeMedida;

    @PostMapping("/unidades-medida")
    public ResponseEntity<UnidadeMedida> salvarUnidadeMedida(@RequestBody UnidadeMedidaDTO unidadeMedidaDTO) {
        var unidadeMedidaModelo = new UnidadeMedida();
        BeanUtils.copyProperties(unidadeMedidaDTO, unidadeMedidaModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioUnidadeMedida.save(unidadeMedidaModelo));
    }

    @GetMapping("/unidades-medida")
    public ResponseEntity<List<UnidadeMedida>> getAllUnidadeMedia(){
        return ResponseEntity.status(HttpStatus.OK).body(repositorioUnidadeMedida.findAll());
    }

    @GetMapping("/unidades-medida/{id}")
    public ResponseEntity<Object> getUnidadeMediaPorId(@PathVariable(value="id") Integer id){
        Optional<UnidadeMedida> unidadeMedida = repositorioUnidadeMedida.findById(id);
        if(unidadeMedida.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade medida "+id+" não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(unidadeMedida.get());
    }

    @PutMapping("/unidades-medida/{id}")
    public ResponseEntity<Object> atualizarUnidadeMedida(@PathVariable(value="id") Integer id, @RequestBody UnidadeMedidaDTO unidadeMedidaDTO) {
        Optional<UnidadeMedida> unidadeMedida = repositorioUnidadeMedida.findById(id);
        if(unidadeMedida.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade medida "+id+" não encontrado.");
        }

        BeanUtils.copyProperties(unidadeMedidaDTO, unidadeMedida.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioUnidadeMedida.save(unidadeMedida.get()));
    }

    @DeleteMapping("/unidades-medida/{id}")
    public ResponseEntity<Object> deletarUnidadeMedida(@PathVariable(value="id") Integer id) {
        Optional<UnidadeMedida> unidadeMedida = repositorioUnidadeMedida.findById(id);
        if(unidadeMedida.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade medida "+id+" não encontrado.");
        }

        repositorioUnidadeMedida.delete(unidadeMedida.get());
        return ResponseEntity.status(HttpStatus.OK).body("Unidade medida "+id+" removido com sucesso.");
    }
}
