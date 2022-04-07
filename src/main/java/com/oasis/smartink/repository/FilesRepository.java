package com.oasis.smartink.repository;

import com.oasis.smartink.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilesRepository extends JpaRepository<Files, UUID> {




}
