package br.com.tech4me.lojanike.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.lojanike.model.Produto;

public interface produtoRepository extends MongoRepository <Produto , String> {
    
}
