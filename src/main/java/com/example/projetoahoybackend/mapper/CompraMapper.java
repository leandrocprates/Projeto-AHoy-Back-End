package com.example.projetoahoybackend.mapper;

import com.example.projetoahoybackend.domain.CompraEntity;
import com.example.projetoahoybackend.model.Compra;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompraMapper {

    public Converter<Compra,List<CompraEntity>> converterListCompraToCompraEntity = new AbstractConverter<Compra,List<CompraEntity>>() {

        @Override
        protected List<CompraEntity> convert(Compra compraModel) {

            ArrayList<CompraEntity> arrayCompraEntity = new ArrayList<>();
            for(Double valor : compraModel.getValor() ){
                CompraEntity compraEntity = new CompraEntity();
                compraEntity.setValor(valor);
                arrayCompraEntity.add(compraEntity);
            }
            return arrayCompraEntity ;
        }

    };


}
