package com.gerencia.sistema.dtos.request;

import com.gerencia.sistema.entidades.Especialidade;

import jakarta.validation.constraints.NotNull;

public record EngenheiroCreateRequest(
    @NotNull
    String nome,
    @NotNull
    String CREA,
    @NotNull
    Especialidade especialidade){

}
