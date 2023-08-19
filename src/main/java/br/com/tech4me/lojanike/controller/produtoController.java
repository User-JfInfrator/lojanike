package br.com.tech4me.lojanike.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.lojanike.service.produtoService;
import br.com.tech4me.lojanike.shared.produtoCompletoDto;
import br.com.tech4me.lojanike.shared.produtoDto;

@RestController
@RequestMapping("/produto")
public class produtoController {
    @Autowired
    private produtoService servico;

    @GetMapping
    public ResponseEntity<List<produtoDto>> obterProduto(){
        return new ResponseEntity<> (servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<produtoCompletoDto> obterProdutoPorId(@PathVariable String idProduto){
        Optional<produtoCompletoDto> produto = servico.obterPorId(idProduto);
    if(produto.isPresent()){
        return new ResponseEntity<>(produto.get(), HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    @PostMapping
    public ResponseEntity<produtoCompletoDto> cadastrarProduto(@RequestBody produtoCompletoDto dto){
        return new ResponseEntity<>(servico.cadastrarProduto(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<produtoCompletoDto> atualizarPorId(@RequestBody produtoCompletoDto dto, @PathVariable String idProduto){
        Optional<produtoCompletoDto> produtoAtualizado = servico.atualizarPorId(idProduto, dto);

        if(produtoAtualizado.isPresent()){
            return new ResponseEntity<>(produtoAtualizado.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Void> excluirPorId(@PathVariable String idProduto){
        servico.excluirProduto(idProduto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
