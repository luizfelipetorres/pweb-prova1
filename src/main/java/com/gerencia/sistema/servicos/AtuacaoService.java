package com.gerencia.sistema.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerencia.sistema.dtos.request.AtuacaoRequest;
import com.gerencia.sistema.dtos.request.ProjetoRequest;
import com.gerencia.sistema.dtos.response.AtuacaoResponse;
import com.gerencia.sistema.dtos.response.ProjetoResponse;
import com.gerencia.sistema.entidades.Atuacao;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.repositorios.AtuacaoRepository;
import com.gerencia.sistema.repositorios.EngenheiroRepository;
import com.gerencia.sistema.repositorios.ProjetoRepository;

@Service
public class AtuacaoService {

  @Autowired
  private AtuacaoRepository atuacaoRepository;

  @Autowired
  private EngenheiroRepository engenheiroRepository;

  @Autowired
  private ProjetoRepository projetoRepository;

  public AtuacaoResponse cadastrar(AtuacaoRequest request){

    var engenheiro = engenheiroRepository.findById(request.engenheiroId());
    var projeto = projetoRepository.findById(request.projetoId());

    if(engenheiro.isPresent() && projeto.isPresent()){
      var entity = new Atuacao(
          engenheiro.get(),
          projeto.get(),
          request.duracao()
      );

      var data = atuacaoRepository.save(entity);
      return new AtuacaoResponse(data);
    }

    return null;
  }

  public Void deletar(Long id){
    atuacaoRepository.deleteById(id);
    return null;
  }
}
