package com.oasis.smartink.repository;

import com.oasis.smartink.model.TrabalhosRealizados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhosRealizadosRepository extends JpaRepository<TrabalhosRealizados, Long> {
}
