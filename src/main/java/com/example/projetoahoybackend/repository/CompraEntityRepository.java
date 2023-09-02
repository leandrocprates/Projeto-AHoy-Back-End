package com.example.projetoahoybackend.repository;

import com.example.projetoahoybackend.domain.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraEntityRepository extends JpaRepository<CompraEntity,Integer> {
}
