package com.example.projetoahoybackend.service;

import com.example.projetoahoybackend.BuscaVO;
import com.example.projetoahoybackend.domain.RegiaoEntity;
import com.example.projetoahoybackend.repository.RegiaoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaDadosService {


    @Autowired
    RegiaoEntityRepository regiaoEntityRepository ;

    public BuscaVO buscarDadosConsolidados(String sigla ){
        Double valor = regiaoEntityRepository.findDadosConsolidadosBySigla(sigla);
        BuscaVO buscaVO = new BuscaVO(sigla,valor);
        return buscaVO ;
    }

}
