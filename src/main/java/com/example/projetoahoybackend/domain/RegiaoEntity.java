package com.example.projetoahoybackend.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Regiao", schema = "ahoy", catalog = "")
public class RegiaoEntity {
    private int id;
    private String sigla;
    private Collection<CompraEntity> compras;
    private Collection<GeracaoEntity> geracoes;
    private Collection<PrecoMedioEntity> precosMedios;
    private AgenteEntity agente;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sigla", nullable = false, length = 10)
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegiaoEntity that = (RegiaoEntity) o;
        return id == that.id && Objects.equals(sigla, that.sigla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sigla);
    }

    @OneToMany(mappedBy = "regiao")
    public Collection<CompraEntity> getCompras() {
        return compras;
    }

    public void setCompras(Collection<CompraEntity> compras) {
        this.compras = compras;
    }

    @OneToMany(mappedBy = "regiao")
    public Collection<GeracaoEntity> getGeracoes() {
        return geracoes;
    }

    public void setGeracoes(Collection<GeracaoEntity> geracoes) {
        this.geracoes = geracoes;
    }

    @OneToMany(mappedBy = "regiao")
    public Collection<PrecoMedioEntity> getPrecosMedios() {
        return precosMedios;
    }

    public void setPrecosMedios(Collection<PrecoMedioEntity> precosMedios) {
        this.precosMedios = precosMedios;
    }

    @ManyToOne
    @JoinColumn(name = "id_agente", referencedColumnName = "id", nullable = false)
    public AgenteEntity getAgente() {
        return agente;
    }

    public void setAgente(AgenteEntity agente) {
        this.agente = agente;
    }
}
