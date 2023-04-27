package com.gerencia.sistema.dtos.request;

import com.gerencia.sistema.entidades.Categoria;
import com.gerencia.sistema.entidades.Especialidade;

import jakarta.validation.constraints.NotNull;

public record ProjetoRequest(
    @NotNull
    String nome,
    @NotNull
    double custo,
    @NotNull
    Categoria categoria){

}
