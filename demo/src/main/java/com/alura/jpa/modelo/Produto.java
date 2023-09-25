package com.alura.jpa.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name="produto") //em caso do nome da tabela no banco seja diferente do nome da classe
public class Produto {

    @Id //indica quem é a chava primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //informa que os valores vao vir do banco o 'strategy varia cada banco usa um'
    private Integer id;
    private String nome;
    private String descricao;
    private double preco;
    private LocalDate dataCadastro = LocalDate.now();
    
    @ManyToOne
    private Categoria categoria;

    public Produto(){
        
    }

    public Produto(String nome, String descicao, double preco, Categoria categoria){
        this.categoria = categoria;
        this.descricao = descicao;
        this.nome = nome;
        this.preco = preco;
    }


    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
       public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
