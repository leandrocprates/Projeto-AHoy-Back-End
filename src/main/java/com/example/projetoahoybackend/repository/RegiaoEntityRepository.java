package com.example.projetoahoybackend.repository;

import com.example.projetoahoybackend.domain.RegiaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegiaoEntityRepository extends JpaRepository<RegiaoEntity,Integer> {

    List<RegiaoEntity> findBySigla(String sigla);

    @Query(value = "SELECT SUM(co.valor) valorA  FROM Regiao re INNER JOIN Compra co ON re.id = co.id_regiao " +
            " WHERE re.sigla = :sigla", nativeQuery = true)
    Double findDadosConsolidadosBySigla(String sigla);


}
