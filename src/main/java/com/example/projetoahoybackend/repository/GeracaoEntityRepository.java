package com.example.projetoahoybackend.repository;

import com.example.projetoahoybackend.domain.GeracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeracaoEntityRepository extends JpaRepository<GeracaoEntity,Integer> {
}
