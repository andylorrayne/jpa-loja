package com.alura.jpa.dao;

import javax.persistence.EntityManager;

import com.alura.jpa.modelo.Categoria;

public class CategoriaDao {
     private EntityManager em;

    public void CategoriaDao(EntityManager em){
        this.em=em;
    }

    public void cadastrar(Categoria categoria){
        this.em.persist(categoria);
    }
}
