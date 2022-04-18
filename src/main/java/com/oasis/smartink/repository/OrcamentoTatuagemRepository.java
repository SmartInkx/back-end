package com.oasis.smartink.repository;

import com.oasis.smartink.model.OrcamentoTatuagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrcamentoTatuagemRepository extends JpaRepository<OrcamentoTatuagem, UUID> {


}
