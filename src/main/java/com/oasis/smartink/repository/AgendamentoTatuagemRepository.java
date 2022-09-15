package com.oasis.smartink.repository;

import com.oasis.smartink.model.AgendamentoTatuagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoTatuagemRepository extends JpaRepository<AgendamentoTatuagem, Long> {
}
