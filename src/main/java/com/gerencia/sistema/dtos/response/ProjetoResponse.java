package com.gerencia.sistema.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gerencia.sistema.entidades.Categoria;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Especialidade;
import com.gerencia.sistema.entidades.Projeto;

public record ProjetoResponse(@JsonIgnore Long id, String nome, Categoria categoria){

  public ProjetoResponse(Projeto request){
    this(request.getId(), request.getNome(), request.getCategoria());
  }
}
