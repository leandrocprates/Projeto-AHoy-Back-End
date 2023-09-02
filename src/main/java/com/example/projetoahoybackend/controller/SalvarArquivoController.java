package com.example.projetoahoybackend.controller;

import com.example.projetoahoybackend.service.SalvarDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
public class SalvarArquivoController {

    @Autowired
    private SalvarDadosService salvarDadosService ;


    @PostMapping(value = "/uploadarquivo")
    public void salvarArquivo(@RequestParam("file") MultipartFile file){
        salvarDadosService.processarArquivo(file);
    }

    @PostMapping("/uploadmultiplosarquivos")
    public void uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
         salvarDadosService.processarListaArquivos(files);
    }

}
