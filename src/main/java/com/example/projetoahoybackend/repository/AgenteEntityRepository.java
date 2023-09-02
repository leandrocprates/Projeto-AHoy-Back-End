package com.example.projetoahoybackend.repository;

import com.example.projetoahoybackend.domain.AgenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteEntityRepository extends JpaRepository<AgenteEntity,Integer> {

}
