package com.example.projetoahoybackend.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Geracao", schema = "ahoy", catalog = "")
public class GeracaoEntity {
    private int id;
    private double valor;
    private RegiaoEntity regiao;

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
    @Column(name = "valor", nullable = false, precision = 0)
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeracaoEntity that = (GeracaoEntity) o;
        return id == that.id && Double.compare(that.valor, valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor);
    }

    @ManyToOne
    @JoinColumn(name = "id_regiao", referencedColumnName = "id", nullable = false)
    public RegiaoEntity getRegiao() {
        return regiao;
    }

    public void setRegiao(RegiaoEntity regiao) {
        this.regiao = regiao;
    }
}
