package br.edu.fateclins.web.prog.restAPIVitrine.controle;

import br.edu.fateclins.web.prog.restAPIVitrine.dto.ClienteDTO;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Cliente;
import br.edu.fateclins.web.prog.restAPIVitrine.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ClienteController {

    @Autowired
    ClienteRepository repositorioCliente;

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        var clienteModelo = new Cliente();
        BeanUtils.copyProperties(clienteDTO, clienteModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioCliente.save(clienteModelo));
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllCliente(){
        return ResponseEntity.status(HttpStatus.OK).body(repositorioCliente.findAll());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Object> getClientePorId(@PathVariable(value="id") Integer id){
        Optional<Cliente> cliente = repositorioCliente.findById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente "+id+" não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable(value="id") Integer id, @RequestBody ClienteDTO clienteDTO) {
        Optional<Cliente> cliente = repositorioCliente.findById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente "+id+" não encontrado.");
        }

        BeanUtils.copyProperties(clienteDTO, cliente.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioCliente.save(cliente.get()));
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable(value="id") Integer id) {
        Optional<Cliente> cliente = repositorioCliente.findById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente "+id+" não encontrado.");
        }

        repositorioCliente.delete(cliente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente "+id+" removido com sucesso.");
    }
}
