package com.example.projetoahoybackend.service;

import com.example.projetoahoybackend.vo.BuscaVO;
import com.example.projetoahoybackend.repository.RegiaoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaDadosService {


    @Autowired
    RegiaoEntityRepository regiaoEntityRepository ;

    public BuscaVO buscarDadosConsolidadosDeCompraBySigla(String sigla ){
        Double valor = regiaoEntityRepository.findDadosConsolidadosDeCompraBySigla(sigla);
        BuscaVO buscaVO = new BuscaVO(sigla,valor);
        return buscaVO ;
    }

    public BuscaVO buscarDadosConsolidadosDeGeracaoBySigla(String sigla ){
        Double valor = regiaoEntityRepository.findDadosConsolidadosGeracaoBySigla(sigla);
        BuscaVO buscaVO = new BuscaVO(sigla,valor);
        return buscaVO ;
    }

    public BuscaVO buscarDadosConsolidadosDePrecoMedioBySigla(String sigla ){
        Double valor = regiaoEntityRepository.findDadosConsolidadosPrecoMedioBySigla(sigla);
        BuscaVO buscaVO = new BuscaVO(sigla,valor);
        return buscaVO ;
    }


}
