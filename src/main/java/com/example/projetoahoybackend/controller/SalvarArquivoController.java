package com.example.projetoahoybackend.controller;

import com.example.projetoahoybackend.service.SalvarDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SalvarArquivoController {

    @Autowired
    private SalvarDadosService salvarDadosService ;


    @PostMapping(value = "/uploadarquivo")
    public ResponseEntity salvarArquivo(@RequestParam("file") MultipartFile file){
        salvarDadosService.processarArquivo(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/uploadmultiplosarquivos")
    public ResponseEntity uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        salvarDadosService.processarListaArquivos(files);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
