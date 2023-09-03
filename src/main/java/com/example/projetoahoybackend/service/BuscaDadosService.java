package com.example.projetoahoybackend.service;

import com.example.projetoahoybackend.BuscaVO;
import com.example.projetoahoybackend.repository.RegiaoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
