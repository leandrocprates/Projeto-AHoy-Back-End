package com.example.projetoahoybackend.mapper;


import com.example.projetoahoybackend.domain.AgenteEntity;
import com.example.projetoahoybackend.model.Agentes;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapearObjetosToDomain {

    static ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("agenteModelMapper")
    ModelMapper agenteModelMapper ;

    public void mapearObjetoToDatabase(Agentes agentes){

        AgenteEntity agenteEntityfora = null;
        agentes.getAgente().stream().forEach(agente -> {
            AgenteEntity agenteEntity = agenteModelMapper.map(agente,AgenteEntity.class);
            System.out.println(agenteEntity.getCodigo());
        });

        return ;
    }

}
