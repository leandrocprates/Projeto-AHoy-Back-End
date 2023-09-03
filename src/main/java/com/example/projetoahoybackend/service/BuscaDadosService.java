package com.example.projetoahoybackend.service;

import com.example.projetoahoybackend.vo.BuscaVO;
import com.example.projetoahoybackend.repository.RegiaoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BuscaDadosService {


    @Autowired
    RegiaoEntityRepository regiaoEntityRepository ;

    public BuscaVO buscarDadosConsolidadosDeCompraBySigla(String sigla ){
        Double valor = regiaoEntityRepository.findDadosConsolidadosDeCompraBySigla(sigla);
        BuscaVO buscaVO = new BuscaVO("Compra",sigla,valor);
        return buscaVO ;
    }

    public BuscaVO buscarDadosConsolidadosDeGeracaoBySigla(String sigla ){
        Double valor = regiaoEntityRepository.findDadosConsolidadosGeracaoBySigla(sigla);
        BuscaVO buscaVO = new BuscaVO("Geracao",sigla,valor);
        return buscaVO ;
    }

    public BuscaVO buscarDadosConsolidadosDePrecoMedioBySigla(String sigla ){
        Double valor = regiaoEntityRepository.findDadosConsolidadosPrecoMedioBySigla(sigla);
        BuscaVO buscaVO = new BuscaVO("PrecoMedio",sigla,valor);
        return buscaVO ;
    }

    public List<BuscaVO> buscarDadosConsolidadosBySigla(String sigla ){
        BuscaVO buscaVOCompra = this.buscarDadosConsolidadosDeCompraBySigla(sigla);
        BuscaVO buscaVOGeracao = this.buscarDadosConsolidadosDeGeracaoBySigla(sigla);
        BuscaVO buscaVOPremio = this.buscarDadosConsolidadosDePrecoMedioBySigla(sigla);
        return Arrays.asList(buscaVOCompra,buscaVOGeracao,buscaVOPremio);
    }





}
