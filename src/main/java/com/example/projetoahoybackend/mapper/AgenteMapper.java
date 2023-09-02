package com.example.projetoahoybackend.mapper;

import com.example.projetoahoybackend.domain.AgenteEntity;
import com.example.projetoahoybackend.model.Agente;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgenteMapper {

    @Autowired
    RegiaoMapper regiaoMapper ;

    @Bean
    public ModelMapper agenteModelMapper(){
        ModelMapper agenteModelMapper = new ModelMapper();

        PropertyMap<Agente, AgenteEntity> agenteToAgenteEntity = new PropertyMap<Agente, AgenteEntity>() {
            @Override
            protected void configure() {
                map().setCodigo(source.getCodigo());
                map().setData(source.getData());
                using(regiaoMapper.converterListRegiaoToRegiaoEntity).map(source.getRegiao()).setRegioes(null);
            }
        };
        agenteModelMapper.addMappings(agenteToAgenteEntity);
        return agenteModelMapper ;
    }


    public Converter<List<Agente>,List<AgenteEntity>> converterListAgenteToAgenteEntity = new AbstractConverter<List<Agente>,List<AgenteEntity>>() {

        @Override
        protected List<AgenteEntity> convert(List<Agente> agenteModel) {
            ModelMapper  agenteModelMapper = agenteModelMapper() ;
            ArrayList<AgenteEntity> arrayAgenteEntity = new ArrayList<>();

            for (Agente agente: agenteModel){
                AgenteEntity agenteEntity = agenteModelMapper.map(agente,AgenteEntity.class);
                arrayAgenteEntity.add(agenteEntity);
            }
            return arrayAgenteEntity;
        }
    };




}
