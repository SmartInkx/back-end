package com.oasis.smartink.repository;

import com.oasis.smartink.model.OrcamentoPiercing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrcamentoPiercingRepository extends JpaRepository<OrcamentoPiercing, UUID> {
    
}
