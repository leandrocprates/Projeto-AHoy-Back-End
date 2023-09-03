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
    Double findDadosConsolidadosDeCompraBySigla(String sigla);


    @Query(value = "SELECT SUM(ge.valor) valorA  FROM Regiao re INNER JOIN Geracao ge ON re.id = ge.id_regiao " +
            "    WHERE re.sigla = :sigla", nativeQuery = true)
    Double findDadosConsolidadosGeracaoBySigla(String sigla);


    @Query(value = " SELECT SUM(pe.valor) valorA  FROM Regiao re INNER JOIN Preco_Medio pe ON re.id = pe.id_regiao " +
            "    WHERE re.sigla = :sigla", nativeQuery = true)
    Double findDadosConsolidadosPrecoMedioBySigla(String sigla);





}
