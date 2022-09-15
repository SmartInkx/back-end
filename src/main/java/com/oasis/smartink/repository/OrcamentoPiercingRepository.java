package com.oasis.smartink.repository;

import com.oasis.smartink.model.OrcamentoPiercing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoPiercingRepository extends JpaRepository<OrcamentoPiercing, Long> {
    
}
