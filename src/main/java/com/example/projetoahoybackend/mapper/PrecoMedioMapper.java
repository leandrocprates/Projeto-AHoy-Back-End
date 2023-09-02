package com.example.projetoahoybackend.mapper;

import com.example.projetoahoybackend.domain.PrecoMedioEntity;
import com.example.projetoahoybackend.model.PrecoMedio;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrecoMedioMapper {

    public Converter<PrecoMedio, List<PrecoMedioEntity>> converterListPrecoMedioToPrecoMedioEntity = new AbstractConverter<PrecoMedio, List<PrecoMedioEntity>>() {

        @Override
        protected List<PrecoMedioEntity> convert(PrecoMedio precoMedioModel) {

            ArrayList<PrecoMedioEntity> arrayPrecoMedioEntity = new ArrayList<>();
            for(Double valor : precoMedioModel.getValor() ){
                PrecoMedioEntity precoMedioEntity = new PrecoMedioEntity();
                precoMedioEntity.setValor(valor);
                arrayPrecoMedioEntity.add(precoMedioEntity);
            }
            return arrayPrecoMedioEntity ;
        }

    };




}
