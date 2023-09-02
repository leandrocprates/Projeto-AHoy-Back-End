package com.example.projetoahoybackend.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Agente", schema = "ahoy", catalog = "")
public class AgenteEntity {
    private int id;
    private int codigo;
    private Date data;
    private ArquivoEntity arquivo;
    private Collection<RegiaoEntity> regioes;

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
    @Column(name = "codigo", nullable = false)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "data", nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgenteEntity that = (AgenteEntity) o;
        return id == that.id && codigo == that.codigo && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, data);
    }

    @ManyToOne
    @JoinColumn(name = "id_arquivo", referencedColumnName = "id", nullable = false)
    public ArquivoEntity getArquivo() {
        return arquivo;
    }

    public void setArquivo(ArquivoEntity arquivo) {
        this.arquivo = arquivo;
    }

    @OneToMany(mappedBy = "agente")
    public Collection<RegiaoEntity> getRegioes() {
        return regioes;
    }

    public void setRegioes(Collection<RegiaoEntity> regioes) {
        this.regioes = regioes;
    }
}
