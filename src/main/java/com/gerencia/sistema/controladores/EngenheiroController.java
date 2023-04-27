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
import com.gerencia.sistema.dtos.response.EngenheiroResponse;
import com.gerencia.sistema.servicos.EngenheiroService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path = "/engenheiros")
public class EngenheiroController {

  @Autowired
  private EngenheiroService service;


  @PostMapping
  public ResponseEntity<EngenheiroResponse> cadastrar(@RequestBody EngenheiroCreateRequest request,
                                                      UriComponentsBuilder builder){

    var data = service.cadastrar(request);
    var uri = builder.path("/engenheiros/{id}").buildAndExpand(data.id()).toUri();
    return  ResponseEntity.created(uri).body(data);
  }

  @GetMapping
  public ResponseEntity<List<EngenheiroResponse>> listarTodos(){
    return ResponseEntity.ok().body(service.listarTodos());
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<EngenheiroResponse> atualizar(@PathVariable Long id, @RequestBody EngenheiroUpdateRequest request){
    return ResponseEntity.ok().body(service.atualizar(id, request));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Void> deletar(@PathVariable Long id){
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
