package com.example.projetoahoybackend.controller;


import com.example.projetoahoybackend.BuscaVO;
import com.example.projetoahoybackend.service.BuscaDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuscaController {


    @Autowired
    BuscaDadosService buscaDadosService ;

    @GetMapping(value="/buscadadossigla")
    public ResponseEntity<BuscaVO> buscarDadosPorRegiao(@RequestParam(value = "sigla") String sigla){
        return new ResponseEntity<>(buscaDadosService.buscarDadosConsolidados(sigla), HttpStatus.OK) ;
    }


}
