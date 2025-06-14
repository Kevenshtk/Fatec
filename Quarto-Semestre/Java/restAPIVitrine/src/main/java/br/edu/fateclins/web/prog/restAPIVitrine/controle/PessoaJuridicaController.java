package br.edu.fateclins.web.prog.restAPIVitrine.controle;

import br.edu.fateclins.web.prog.restAPIVitrine.dto.PessoaJuridicaDTO;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.PessoaJuridica;
import br.edu.fateclins.web.prog.restAPIVitrine.repository.PessoaJuridicaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaJuridicaController {

    @Autowired
    PessoaJuridicaRepository repositorioPessoaJuridica;

    @PostMapping("/pessoas-juridicas")
    public ResponseEntity<PessoaJuridica> salvarPessoaJuridica(@RequestBody PessoaJuridicaDTO pessoaJuridicaDTO) {
        var pessoaJuridicaModelo = new PessoaJuridica();
        BeanUtils.copyProperties(pessoaJuridicaDTO, pessoaJuridicaModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioPessoaJuridica.save(pessoaJuridicaModelo));
    }
}
