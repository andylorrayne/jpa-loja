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

    public void atualizar(Categoria categoria){
        this.em.merge(categoria);
    }

    // não pode remover entidade que esteja em detached
    public void remover(Categoria categoria){
        categoria = em.merge(categoria); //usar o marge requer que você reatribuir
        this.em.remove(categoria);
    }


}
