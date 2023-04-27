package com.gerencia.sistema.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerencia.sistema.dtos.request.ProjetoRequest;
import com.gerencia.sistema.dtos.response.ProjetoResponse;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.repositorios.ProjetoRepository;

@Service
public class ProjetoService {

  @Autowired
  private ProjetoRepository repository;

  public ProjetoResponse cadastrar(ProjetoRequest request){
    var data = repository.save(new Projeto(request));
    return new ProjetoResponse(data);
  }

  public List<ProjetoResponse> listarTodos(){
    return repository.findAll().stream().map(ProjetoResponse::new).collect(Collectors.toList());
  }

  public ProjetoResponse atualizar(Long id, ProjetoRequest request){
    return repository.findById(id).map(
        record -> {
          record.setNome(request.nome());
          record.setCusto(request.custo());
          record.setCategoria(request.categoria());
          var data = repository.save(record);
          return new ProjetoResponse(data);
        }
    ).orElse(null);
  }

  public Void deletar(Long id){
    repository.deleteById(id);
    return null;
  }
}
