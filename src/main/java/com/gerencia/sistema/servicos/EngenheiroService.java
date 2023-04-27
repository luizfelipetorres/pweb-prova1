package com.gerencia.sistema.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerencia.sistema.dtos.request.EngenheiroCreateRequest;
import com.gerencia.sistema.dtos.request.EngenheiroUpdateRequest;
import com.gerencia.sistema.dtos.response.EngenheiroResponse;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.repositorios.EngenheiroRepository;

@Service
public class EngenheiroService {

  @Autowired
  private EngenheiroRepository repository;

  public EngenheiroResponse cadastrar(EngenheiroCreateRequest request) {
    var data = repository.save(new Engenheiro(request));
    return new EngenheiroResponse(data);
  }

  public List<EngenheiroResponse> listarTodos() {
    return repository
        .findAll()
        .stream()
        .map(EngenheiroResponse::new).toList();
  }

  public EngenheiroResponse atualizar(Long id, EngenheiroUpdateRequest request) {
    return repository
        .findById(id)
        .map(
            record -> {
              record.setNome(request.nome());
              record.setEspecialidade(request.especialidade());
              var data = repository.save(record);
              return new EngenheiroResponse(data);
            }
        )
        .orElse(null);
  }

  public Void deletar(Long id) {
    repository.deleteById(id);
    return null;
  }
}
