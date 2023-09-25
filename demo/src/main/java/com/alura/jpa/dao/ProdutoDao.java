package com.alura.jpa.dao;

import javax.persistence.EntityManager;

import com.alura.jpa.modelo.Produto;

public class ProdutoDao {
    private EntityManager em;

    public void ProdutoDao(EntityManager em){
        this.em=em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }
    
    
}
