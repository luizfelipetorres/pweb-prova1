package com.gerencia.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerencia.sistema.entidades.Engenheiro;

@Repository
public interface EngenheiroRepository extends JpaRepository<Engenheiro, Long> {

}
