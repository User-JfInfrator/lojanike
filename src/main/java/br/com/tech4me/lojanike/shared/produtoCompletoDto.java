package br.com.tech4me.lojanike.shared;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record produtoCompletoDto(String idProduto,
@NotEmpty(message = "O campo de nome deve ser preenchido!")
@NotBlank(message = "Está preenchido, porém com caracteres em branco!")
String nomeProduto,
@Positive(message = "Informe um valor positivo para o produto")
double valor,
@PositiveOrZero(message = "Informe uma quantidade acima de zero para o produto")
int qtd) {
    
}
