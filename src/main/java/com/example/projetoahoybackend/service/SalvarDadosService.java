package com.example.projetoahoybackend.service;

import com.example.projetoahoybackend.model.Agentes;
import com.example.projetoahoybackend.repository.AgenteEntityRepository;
import com.example.projetoahoybackend.repository.ArquivoEntityRepository;
import com.example.projetoahoybackend.utils.ArquivoConverter;
import com.example.projetoahoybackend.mapper.MapearObjetosToDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Arrays;

@Service
public class SalvarDadosService {

    @Autowired
    private ArquivoEntityRepository arquivoEntityRepository ;

    @Autowired
    private AgenteEntityRepository agenteEntityRepository ;

    @Autowired
    private ArquivoConverter arquivoConverter ;

    @Autowired
    MapearObjetosToDomain mapearObjetosToDomain ;

    public void processarListaArquivos(MultipartFile[] files){

        System.out.println("==== Iniciando metodo processarListaArquivos ====");
        Arrays.asList(files)
                .stream()
                .forEach(file -> {
                    processarArquivo(file);
                });

        System.out.println("==== Fim metodo processarListaArquivos ====");
    }

    public void processarArquivo(MultipartFile file){

        System.out.println("==== Iniciando metodo processararquivo ====");
        System.out.println("Nome arquivo : "+ file.getOriginalFilename());
        System.out.println("Tamanho arquivo : "+ file.getSize());
        System.out.println("ContentType : "+ file.getContentType());

        try{
            Agentes agentes = arquivoConverter.converterArquivoXmlToObject(file);

            mapearObjetosToDomain.mapearObjetoToDatabase(agentes);


        }catch(Exception ex){
            System.err.println("Erro ao converter arquivo : "+ file.getOriginalFilename());
        }

        System.out.println("==== Fim metodo processararquivo ====");

    }


    public void salvarDados(){

        //agenteEntityRepository.save(null);
    }


}
