package com.gerencia.sistema.dtos.request;

import com.gerencia.sistema.entidades.Categoria;

import jakarta.validation.constraints.NotNull;

public record AtuacaoRequest(
    @NotNull
    Long engenheiroId,
    @NotNull
    Long projetoId,
    @NotNull
    int duracao){

}
