package br.edu.fateclins.web.prog.restAPIVitrine.controle;

import br.edu.fateclins.web.prog.restAPIVitrine.dto.ItensVendidosDTO;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.ItensVendidos;
import br.edu.fateclins.web.prog.restAPIVitrine.repository.ItensVendidosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItensVendidosController {

    @Autowired
    ItensVendidosRepository repositorioItensVendidos;

    @PostMapping("/itens-vendidos")
    public ResponseEntity<ItensVendidos> salvarItensVendidos(@RequestBody ItensVendidosDTO itensVendidosDTO) {
        var itensVendidosModelo = new ItensVendidos();
        BeanUtils.copyProperties(itensVendidosDTO, itensVendidosModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioItensVendidos.save(itensVendidosModelo));
    }
}
