<?php

namespace App\Models\Entidades;

use DateTime;

class Produto
{
    private $id;
    private $nome;
    private $preco;
    private $quantidade;
    private $descricao;
    private $dataCadastro;

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;
    }

    public function getNome()
    {
        return $this->nome;
    }

    public function setNome($nome)
    {
        $this->nome = $nome;
    }

    public function getPreco()
    {
        return $this->preco;
    }

    public function setPreco($preco)
    {
        $this->preco = $preco;
    }

    public function getQuantidade()
    {
        return $this->quantidade;
    }

    public function setQuantidade($quantidade)
    {
        $this->quantidade = $quantidade;
    }

    public function getDescricao()
    {
        return $this->descricao;
    }

    public function setDescricao($descricao)
    {
        $this->descricao = $descricao;
    }

    public function getDataCadastro()
    {
        return new DateTime($this->dataCadastro);
    }

    public function setDataCadastro($dataCadastro)
    {
        $this->dataCadastro = $dataCadastro;
    }
    
    public function setProduto($dados) {
      if (isset($dados['id']))$this->id = $dados['id'];
      if (isset($dados['nome']))$this->nome = $dados['nome'];
      if (isset($dados['preco']))$this->preco = $dados['preco'];
      if (isset($dados['quantidade']))$this->quantidade = $dados['quantidade'];
      if (isset($dados['descricao']))$this->descricao = $dados['descricao'];
      if (isset($dados['dataCadastro']))$this->dataCadastro = $dados['dataCadastro'];
    }

}
