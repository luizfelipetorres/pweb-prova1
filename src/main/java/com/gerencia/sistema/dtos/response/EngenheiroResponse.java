package com.gerencia.sistema.dtos.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Especialidade;

public record EngenheiroResponse(@JsonIgnore Long id, String nome, Especialidade especialidade){

  public EngenheiroResponse(Engenheiro request){
    this(request.getId(), request.getNome(), request.getEspecialidade());
  }
}
