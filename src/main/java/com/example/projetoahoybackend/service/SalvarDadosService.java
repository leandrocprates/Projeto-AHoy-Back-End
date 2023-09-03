package com.example.projetoahoybackend.service;

import com.example.projetoahoybackend.domain.AgenteEntity;
import com.example.projetoahoybackend.domain.ArquivoEntity;
import com.example.projetoahoybackend.domain.RegiaoEntity;
import com.example.projetoahoybackend.model.Agentes;
import com.example.projetoahoybackend.repository.*;
import com.example.projetoahoybackend.utils.ArquivoConverter;
import com.example.projetoahoybackend.mapper.MapearObjetosToDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class SalvarDadosService {

    @Autowired
    private ArquivoEntityRepository arquivoEntityRepository ;

    @Autowired
    private AgenteEntityRepository agenteEntityRepository ;

    @Autowired
    private RegiaoEntityRepository regiaoEntityRepository ;

    @Autowired
    private CompraEntityRepository compraEntityRepository ;

    @Autowired
    private GeracaoEntityRepository geracaoEntityRepository ;

    @Autowired
    private PrecoMedioEntityRepository precoMedioEntityRepository ;

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
        //System.out.println("Nome arquivo : "+ file.getOriginalFilename());

        try{
            Agentes agentes = arquivoConverter.converterArquivoXmlToObject(file);
            agentes.getAgente().forEach(agente -> {
                System.out.println("Codigo Agente: " + agente.getCodigo());
            });

            ArrayList<AgenteEntity> listaAgente =  mapearObjetosToDomain.mapearObjetoToDatabase(agentes);
            salvarDadosArquivoDomain(file,listaAgente);

        }catch(Exception ex){
            System.err.println(ex.getMessage());
            System.err.println("Erro ao converter arquivo : "+ file.getOriginalFilename());
        }

        System.out.println("==== Fim metodo processararquivo ====");

    }

    public void salvarDadosArquivoDomain(MultipartFile file, ArrayList<AgenteEntity> listaAgente ) {
        ArquivoEntity arquivoEntity = new ArquivoEntity();
        arquivoEntity.setNome(file.getOriginalFilename());
        arquivoEntity.setAgentes(listaAgente);

        long start = System.currentTimeMillis();

        ArquivoEntity arquivoEntitySalvo = arquivoEntityRepository.save(arquivoEntity);

        //criar threads para executar em paralelo

        Executor executor = Executors.newFixedThreadPool(30);
        var futureAgentes = arquivoEntity.getAgentes().stream()
                .map(agenteEntity -> CompletableFuture.runAsync(
                        () -> processarAgentes(agenteEntity, arquivoEntitySalvo), executor)
                ).collect(toList());

        var categories = futureAgentes.stream()
                .map(CompletableFuture::join)
                .collect(toList());

        long end = System.currentTimeMillis();
        System.out.printf("The operation took %s ms%n", end - start);


    }

    public void processarAgentes(AgenteEntity agenteEntity,ArquivoEntity arquivoEntitySalvo){

            //arquivoEntity.getAgentes().forEach(agenteEntity -> {
                agenteEntity.setArquivo(arquivoEntitySalvo);
                AgenteEntity agenteEntitySalvo = agenteEntityRepository.save(agenteEntity);

                agenteEntity.getRegioes().forEach(regiaoEntity -> {
                    regiaoEntity.setAgente(agenteEntitySalvo);
                    RegiaoEntity regiaoEntitySalvo = regiaoEntityRepository.save(regiaoEntity);

                    regiaoEntity.getCompras().forEach(compraEntity -> {
                        compraEntity.setRegiao(regiaoEntitySalvo);
                        compraEntityRepository.save(compraEntity);
                    });

                    regiaoEntity.getGeracoes().forEach(geracaoEntity -> {
                        geracaoEntity.setRegiao(regiaoEntitySalvo);
                        geracaoEntityRepository.save(geracaoEntity);
                    });

                    regiaoEntity.getPrecosMedios().forEach(precoMedioEntity -> {
                        precoMedioEntity.setRegiao(regiaoEntitySalvo);
                        precoMedioEntityRepository.save(precoMedioEntity);
                    });

                });

            //});



    }



}
