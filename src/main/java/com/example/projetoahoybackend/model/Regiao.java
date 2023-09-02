package com.example.projetoahoybackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Regiao {
    @XmlElement
    public Geracao geracao;
    @XmlElement
    public Compra compra;
    @XmlElement
    public PrecoMedio precoMedio;
    @XmlAttribute
    public String sigla;


}
