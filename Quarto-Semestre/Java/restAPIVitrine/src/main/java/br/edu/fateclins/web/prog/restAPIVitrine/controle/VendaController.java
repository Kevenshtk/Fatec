package br.edu.fateclins.web.prog.restAPIVitrine.controle;

import br.edu.fateclins.web.prog.restAPIVitrine.dto.VendaDTO;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Venda;
import br.edu.fateclins.web.prog.restAPIVitrine.repository.VendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController {

    @Autowired
    VendaRepository repositorioVenda;

    @PostMapping("/vendas")
    public ResponseEntity<Venda> salvarVenda(@RequestBody VendaDTO vendaDTO) {
        var vendaModelo = new Venda();
        BeanUtils.copyProperties(vendaDTO, vendaModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioVenda.save(vendaModelo));
    }
}
