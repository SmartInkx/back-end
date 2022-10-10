package com.oasis.smartink.repository;

import com.oasis.smartink.model.EstiloTatuagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstiloTatuagemRepository extends JpaRepository<EstiloTatuagem, Long> {
}
