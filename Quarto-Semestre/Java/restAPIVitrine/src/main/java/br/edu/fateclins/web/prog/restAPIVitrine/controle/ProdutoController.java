package br.edu.fateclins.web.prog.restAPIVitrine.controle;

import br.edu.fateclins.web.prog.restAPIVitrine.dto.ProdutoDTO;
import br.edu.fateclins.web.prog.restAPIVitrine.modelo.loja.Produto;
import br.edu.fateclins.web.prog.restAPIVitrine.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProdutoController {

    @Autowired
    ProdutoRepository repositorioProduto;

    @PostMapping("/produtos")
    public ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        var produtoModelo = new Produto();
        BeanUtils.copyProperties(produtoDTO, produtoModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioProduto.save(produtoModelo));
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getAllProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(repositorioProduto.findAll());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Object> getProdutoPorId(@PathVariable(value="id") Integer id){
        Optional<Produto> produto = repositorioProduto.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto de id "+id+" não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable(value="id") Integer id, @RequestBody ProdutoDTO produtoDTO) {
        Optional<Produto> produto = repositorioProduto.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto de id "+id+" não encontrado.");
        }

        BeanUtils.copyProperties(produtoDTO, produto.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioProduto.save(produto.get()));
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable(value="id") Integer id) {
        Optional<Produto> produto = repositorioProduto.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto de id "+id+" não encontrado.");
        }

        repositorioProduto.delete(produto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto id "+id+" removido com sucesso.");
    }
}
