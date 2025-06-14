package br.edu.fateclins.web.prog.restAPIVitrine.controle;

import br.edu.fateclins.web.prog.restAPIVitrine.dto.PessoaFisicaDTO;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.PessoaFisica;
import br.edu.fateclins.web.prog.restAPIVitrine.repository.PessoaFisicaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @PostMapping("/pessoas-fisicas")
    public ResponseEntity<PessoaFisica> salvarPessoaFisica(@RequestBody PessoaFisicaDTO pessoaFisicaDTO) {
        var pessoaFisicaModelo = new PessoaFisica();
        BeanUtils.copyProperties(pessoaFisicaDTO, pessoaFisicaModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFisicaRepository.save(pessoaFisicaModelo));
    }
}
