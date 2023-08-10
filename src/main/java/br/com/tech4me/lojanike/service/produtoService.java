package br.com.tech4me.lojanike.service;

import java.util.List;

import java.util.Optional;

import br.com.tech4me.lojanike.shared.produtoCompletoDto;
import br.com.tech4me.lojanike.shared.produtoDto;

public interface produtoService {
    List<produtoDto> obterTodos();
    Optional<produtoCompletoDto> obterPorId(String idProduto);
    produtoCompletoDto cadastrarProduto(produtoCompletoDto dto);
    Optional<produtoCompletoDto> atualizarPorId(String idProduto, produtoCompletoDto dto);
    void excluirProduto(String idProduto); 


}
