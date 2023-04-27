package com.gerencia.sistema.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gerencia.sistema.dtos.request.EngenheiroCreateRequest;
import com.gerencia.sistema.dtos.request.EngenheiroUpdateRequest;
import com.gerencia.sistema.dtos.request.ProjetoRequest;
import com.gerencia.sistema.dtos.response.EngenheiroResponse;
import com.gerencia.sistema.dtos.response.ProjetoResponse;
import com.gerencia.sistema.servicos.EngenheiroService;
import com.gerencia.sistema.servicos.ProjetoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path = "/projetos")
public class ProjetoController {

  @Autowired
  private ProjetoService service;


  @PostMapping
  public ResponseEntity<ProjetoResponse> cadastrar(@RequestBody ProjetoRequest request,
                                                   UriComponentsBuilder builder){

    var data = service.cadastrar(request);
    var uri = builder.path("/projetos/{id}").buildAndExpand(data.id()).toUri();
    return  ResponseEntity.created(uri).body(data);
  }

  @GetMapping
  public ResponseEntity<List<ProjetoResponse>> listarTodos(){
    return ResponseEntity.ok().body(service.listarTodos());
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<ProjetoResponse> atualizar(@PathVariable Long id, @RequestBody ProjetoRequest request){
    return ResponseEntity.ok().body(service.atualizar(id, request));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Void> deletar(@PathVariable Long id){
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
