package br.com.tech4me.lojanike.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import br.com.tech4me.lojanike.model.Produto;
import br.com.tech4me.lojanike.repository.produtoRepository;
import br.com.tech4me.lojanike.shared.produtoCompletoDto;
import br.com.tech4me.lojanike.shared.produtoDto;

@Service
public class produtoServiceImpl implements produtoService {

    @Autowired
    private produtoRepository repositorio;

    @Override
    public List<produtoDto> obterTodos(){
        return repositorio.findAll().stream().map(p -> new produtoDto(p.getNomeProduto(), p.getValor())).toList();
    }

    @Override
    public Optional<produtoCompletoDto> obterPorId(String idProduto) {
        Optional<Produto> produto = repositorio.findById(idProduto);

        if(produto.isPresent()){
            return Optional.of(new produtoCompletoDto(produto.get().getIdProduto(),
            produto.get().getNomeProduto(), produto.get().getValor(), produto.get().getQtd()));
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public produtoCompletoDto cadastrarProduto(produtoCompletoDto dto) {
        Produto produto = new Produto(dto);
        repositorio.save(produto);

        return new produtoCompletoDto(produto.getIdProduto(), produto.getNomeProduto(), produto.getValor(), produto.getQtd());
    }

    @Override
    public Optional<produtoCompletoDto> atualizarPorId(String idProduto, produtoCompletoDto dto) {
        Optional<Produto> produto = repositorio.findById(idProduto);

        if(produto.isPresent()){
            Produto produtoAtualizado = new Produto(dto);
            produtoAtualizado.setIdProduto(idProduto);
            repositorio.save(produtoAtualizado);
            return Optional.of(new produtoCompletoDto(produtoAtualizado.getIdProduto(),
            produtoAtualizado.getNomeProduto(), produtoAtualizado.getValor(), produtoAtualizado.getQtd()));
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public void excluirProduto(String idProduto) {
        repositorio.deleteById(idProduto);
    }

}
