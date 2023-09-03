package com.example.projetoahoybackend.controller;


import com.example.projetoahoybackend.vo.BuscaVO;
import com.example.projetoahoybackend.service.BuscaDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BuscaController {

    @Autowired
    BuscaDadosService buscaDadosService ;

    @GetMapping(value="/buscadadoscomprasigla")
    public ResponseEntity<BuscaVO> buscarDadosCompraPorRegiao(@RequestParam(value = "sigla") String sigla){
        return new ResponseEntity<>(buscaDadosService.buscarDadosConsolidadosDeCompraBySigla(sigla), HttpStatus.OK) ;
    }

    @GetMapping(value="/buscadadosgeracaosigla")
    public ResponseEntity<BuscaVO> buscarDadosGeracaoPorRegiao(@RequestParam(value = "sigla") String sigla){
        return new ResponseEntity<>(buscaDadosService.buscarDadosConsolidadosDeGeracaoBySigla(sigla), HttpStatus.OK) ;
    }

    @GetMapping(value="/buscadadosprecomediosigla")
    public ResponseEntity<BuscaVO> buscarDadosPrecoMedioPorRegiao(@RequestParam(value = "sigla") String sigla){
        return new ResponseEntity<>(buscaDadosService.buscarDadosConsolidadosDePrecoMedioBySigla(sigla), HttpStatus.OK) ;
    }

    @GetMapping(value="/buscadaconsolidadossigla")
    public ResponseEntity<List<BuscaVO>> buscarDadosConsolidadosPorRegiao(@RequestParam(value = "sigla") String sigla){
        return new ResponseEntity<>(buscaDadosService.buscarDadosConsolidadosBySigla(sigla), HttpStatus.OK) ;
    }


}
