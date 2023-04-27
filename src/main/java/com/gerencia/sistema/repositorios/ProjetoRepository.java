package com.gerencia.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerencia.sistema.entidades.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
