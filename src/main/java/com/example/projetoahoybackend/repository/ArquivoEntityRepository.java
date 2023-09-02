package com.example.projetoahoybackend.repository;

import com.example.projetoahoybackend.domain.ArquivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoEntityRepository extends JpaRepository<ArquivoEntity,Integer> {
}
