package com.example.projetoahoybackend.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Arquivo", schema = "ahoy", catalog = "")
public class ArquivoEntity {
    private int id;
    private String nome;
    private Collection<AgenteEntity> agentes;

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
    @Column(name = "nome", nullable = false, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArquivoEntity that = (ArquivoEntity) o;
        return id == that.id && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @OneToMany(mappedBy = "arquivo")
    public Collection<AgenteEntity> getAgentes() {
        return agentes;
    }

    public void setAgentes(Collection<AgenteEntity> agentes) {
        this.agentes = agentes;
    }
}
