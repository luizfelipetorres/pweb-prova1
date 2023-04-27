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

import com.gerencia.sistema.dtos.request.AtuacaoRequest;
import com.gerencia.sistema.dtos.request.ProjetoRequest;
import com.gerencia.sistema.dtos.response.AtuacaoResponse;
import com.gerencia.sistema.dtos.response.ProjetoResponse;
import com.gerencia.sistema.servicos.AtuacaoService;
import com.gerencia.sistema.servicos.ProjetoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/atuacoes")
public class AtuacaoController {

  @Autowired
  private AtuacaoService service;


  @PostMapping
  public ResponseEntity<AtuacaoResponse> cadastrar(@RequestBody @Valid AtuacaoRequest request,
                                                   UriComponentsBuilder builder){

    var data = service.cadastrar(request);
    var uri = builder.path("/atuacoes/{id}").buildAndExpand(data.id()).toUri();
    return  ResponseEntity.created(uri).body(data);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Void> deletar(@PathVariable Long id){
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
