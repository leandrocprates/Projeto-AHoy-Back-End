package com.example.projetoahoybackend.mapper;

import com.example.projetoahoybackend.domain.CompraEntity;
import com.example.projetoahoybackend.domain.GeracaoEntity;
import com.example.projetoahoybackend.model.Compra;
import com.example.projetoahoybackend.model.Geracao;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeracaoMapper {


    public Converter<Geracao, List<GeracaoEntity>> converterListGeracaoToGeracaoEntity = new AbstractConverter<Geracao,List<GeracaoEntity>>() {

        @Override
        protected List<GeracaoEntity> convert(Geracao geracaoModel) {

            ArrayList<GeracaoEntity> arrayGeracaoEntity = new ArrayList<>();
            for(Double valor : geracaoModel.getValor() ){
                GeracaoEntity geracaoEntity = new GeracaoEntity();
                geracaoEntity.setValor(valor);
                arrayGeracaoEntity.add(geracaoEntity);
            }
            return arrayGeracaoEntity ;
        }

    };

}
