package com.alura.jpa.dao;

import java.util.List;

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
    
    public void atualizar(Produto produto){
        this.em.merge(produto);
    }

    // não pode remover entidade que esteja em detached
    public void remover(Produto produto){
        produto = em.merge(produto); //usar o marge requer que você reatribuir
        this.em.remove(produto);
    }

    public Produto buscaProdutoID(Integer id){
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        String jpgl = "SELECT p FROM Produto p";
        return em.createQuery(jpgl, Produto.class).getResultList();
    }
    
}
