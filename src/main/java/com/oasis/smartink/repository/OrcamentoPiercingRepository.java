package com.oasis.smartink.repository;

import com.oasis.smartink.model.OrcamentoPiercing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrcamentoPiercingRepository extends JpaRepository<OrcamentoPiercing, UUID> {
    
}
