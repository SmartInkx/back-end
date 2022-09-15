package com.oasis.smartink.repository;

import com.oasis.smartink.model.AgendamentoPiercing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoPiercingRepository extends JpaRepository<AgendamentoPiercing, Long> {
}
