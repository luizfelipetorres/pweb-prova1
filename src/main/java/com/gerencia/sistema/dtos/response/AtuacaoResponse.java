package com.gerencia.sistema.dtos.response;

import com.gerencia.sistema.entidades.Atuacao;
import com.gerencia.sistema.entidades.Categoria;
import com.gerencia.sistema.entidades.Projeto;

public record AtuacaoResponse(Long id, EngenheiroResponse engenheiro, ProjetoResponse projeto, int duracao){

  public AtuacaoResponse(Atuacao request){
    this(
        request.getId(),
        new EngenheiroResponse(request.getEngenheiro()),
        new ProjetoResponse(request.getProjeto()),
        request.getDuracao()
    );
  }
}
