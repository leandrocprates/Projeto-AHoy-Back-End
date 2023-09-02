package com.example.projetoahoybackend.repository;

import com.example.projetoahoybackend.domain.PrecoMedioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoMedioEntityRepository extends JpaRepository<PrecoMedioEntity, Integer> {
}
