package br.com.tech4me.lojanike.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.lojanike.shared.produtoCompletoDto;

@Document("produto")
public class Produto {
    
    @Id
    private String idProduto;
    private String nomeProduto;
    private double valor;
    private int qtd;

    public Produto(){}

    public Produto(produtoCompletoDto dto) {
        this.idProduto = dto.idProduto();
        this.nomeProduto = dto.nomeProduto();
        this.valor = dto.valor();
        this.qtd = dto.qtd();
    }
    public String getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
