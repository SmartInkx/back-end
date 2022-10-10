package com.oasis.smartink.repository;

import com.oasis.smartink.model.MaterialPiercing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialPiercingRepository extends JpaRepository<MaterialPiercing, Long> {
}
