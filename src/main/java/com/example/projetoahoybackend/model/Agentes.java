package com.example.projetoahoybackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Agentes {
    @XmlElement
    public List<Agente> agente;
    @XmlAttribute
    public String versao;
}
