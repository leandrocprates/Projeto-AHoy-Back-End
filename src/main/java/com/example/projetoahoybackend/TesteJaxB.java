package com.example.projetoahoybackend;

import com.example.projetoahoybackend.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class TesteJaxB {

    public static Agentes createAgentes(){

        Agentes agentes = new Agentes();
        agentes.setVersao("1.0");

        Agente agente1 = new Agente();
        agente1.setCodigo(1);
        agente1.setData(new Date());


        Geracao geracao1 = new Geracao();
        geracao1.setValor(Arrays.asList(3.2,6.7,45.89));

        Compra compra1 = new Compra();
        compra1.setValor(Arrays.asList(30.87,98.54,100.45));

        PrecoMedio precoMedio1 = new PrecoMedio();
        precoMedio1.setValor(Arrays.asList(41.23,56.32,60.91));

        Regiao regiao1 = new Regiao();
        regiao1.setSigla("SE");
        regiao1.setGeracao(geracao1);
        regiao1.setCompra(compra1);
        regiao1.setPrecoMedio(precoMedio1);

        agente1.setRegiao(Arrays.asList(regiao1));
        agentes.setAgente(Arrays.asList(agente1));
        return agentes;

    }

    public static void main(String[] args) throws JAXBException, IOException {
        //marshall();
        unmarshall();
    }

    public static void marshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Agentes.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(createAgentes(), new File("./book.xml"));
    }

    public static void unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Agentes.class);
        Agentes agentes = (Agentes) context.createUnmarshaller()
                .unmarshal(new FileReader("./exemplo_03.xml"));
        return ;
    }


}
