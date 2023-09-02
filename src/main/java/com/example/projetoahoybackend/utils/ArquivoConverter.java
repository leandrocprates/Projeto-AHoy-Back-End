package com.example.projetoahoybackend.utils;

import com.example.projetoahoybackend.model.Agentes;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Component
public class ArquivoConverter {

    public Agentes converterArquivoXmlToObject(MultipartFile file) throws IOException, JAXBException {
        System.out.println("==== Iniciando metodo converterArquivoXmlToObject ====");
        Agentes agentes = unmarshall(file);
        System.out.println("==== Fim metodo converterArquivoXmlToObject ====");
        return agentes ;
    }

    public Agentes unmarshall(MultipartFile file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Agentes.class);
        Agentes agentes = (Agentes) context.createUnmarshaller()
                .unmarshal(file.getInputStream());
        return agentes ;
    }


}
