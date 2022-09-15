package com.oasis.smartink.repository;

import com.oasis.smartink.model.OrcamentoTatuagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoTatuagemRepository extends JpaRepository<OrcamentoTatuagem, Long> {


}
