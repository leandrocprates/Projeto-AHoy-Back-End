package com.example.projetoahoybackend.repository;

import com.example.projetoahoybackend.domain.RegiaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoEntityRepository extends JpaRepository<RegiaoEntity,Integer> {
}
