package com.gerencia.sistema.dtos.request;

import com.gerencia.sistema.entidades.Especialidade;

import jakarta.validation.constraints.NotNull;

public record EngenheiroUpdateRequest(
    @NotNull
    String nome,
    @NotNull
    Especialidade especialidade){

}
