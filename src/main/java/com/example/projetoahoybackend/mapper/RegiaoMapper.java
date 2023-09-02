package com.example.projetoahoybackend.mapper;

import com.example.projetoahoybackend.domain.RegiaoEntity;
import com.example.projetoahoybackend.model.Regiao;
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
public class RegiaoMapper {


    @Autowired
    CompraMapper compraMapper ;

    @Autowired
    GeracaoMapper geracaoMapper ;

    @Autowired
    PrecoMedioMapper precoMedioMapper ;

    @Bean
    public ModelMapper regiaoModelMapper(){
        ModelMapper regiaoModelMapper = new ModelMapper();

        PropertyMap<Regiao, RegiaoEntity> regiaoToRegiaoEntity = new PropertyMap<Regiao, RegiaoEntity>() {
            @Override
            protected void configure() {
                map().setSigla(source.getSigla());
                using(compraMapper.converterListCompraToCompraEntity).map(source.getCompra()).setCompras(null);
                using(geracaoMapper.converterListGeracaoToGeracaoEntity).map(source.getGeracao()).setGeracoes(null);
                using(precoMedioMapper.converterListPrecoMedioToPrecoMedioEntity).map(source.getPrecoMedio()).setPrecosMedios(null);
            }
        };
        regiaoModelMapper.addMappings(regiaoToRegiaoEntity);
        return regiaoModelMapper ;
    }


    public Converter<List<Regiao>,List<RegiaoEntity>> converterListRegiaoToRegiaoEntity = new AbstractConverter<List<Regiao>,List<RegiaoEntity>>() {

        @Override
        protected List<RegiaoEntity> convert(List<Regiao> regiaoModel) {
            ModelMapper  regiaoModelMapper =  regiaoModelMapper() ;
            ArrayList<RegiaoEntity> arrayRegiaoEntity = new ArrayList<>();

            for (Regiao regiao: regiaoModel){
                RegiaoEntity regiaoEntity = regiaoModelMapper.map(regiao,RegiaoEntity.class);
                arrayRegiaoEntity.add(regiaoEntity);
            }
            return arrayRegiaoEntity;
        }
    };



}
