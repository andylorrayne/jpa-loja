package com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;


import com.alura.jpa.modelo.Categoria;
import com.alura.jpa.modelo.Produto;
import com.alura.jpa.util.JPAutil;
import com.alura.jpa.dao.CategoriaDao;
import com.alura.jpa.dao.ProdutoDao;


public class CadastroDeProdutos {
    public static void main(String[] args) {
        //cadastrarProduto();

        EntityManager em = JPAutil.getEntityMenager(); //substitui o codigo acima
        ProdutoDao produtoDao = new ProdutoDao();        
        produtoDao.ProdutoDao(em);

        Produto p = produtoDao.buscaProdutoID(30);
        
        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p2 -> System.out.println(p2.getNome()));
        



    }

    private static void cadastrarProduto() {
        Categoria eletrodomestico = new Categoria("ELETRONOMESTICO");

        Produto celular = new Produto("ELETROLUX MAQUINA DE LAVAR", "MAQUINA DE LAVAR", 2500.00, eletrodomestico);
        
        //aqui é onde criamos a conexão, e usamos padrao de projeto FACTORY
        //EntityManagerFactory  factory = Persistence.createEntityManagerFactory("loja_virtual");
       // EntityManager em = factory.createEntityManager();

        EntityManager em = JPAutil.getEntityMenager(); //substitui o codigo acima

        CategoriaDao cdao = new CategoriaDao();
        ProdutoDao produtoDao = new ProdutoDao();
        cdao.CategoriaDao(em);
        produtoDao.ProdutoDao(em);
        //abre a conexao
        em.getTransaction().begin();

        

        //executa a ação desejada
        cdao.cadastrar(eletrodomestico);
        produtoDao.cadastrar(celular);;

        //envia e salva as inf
        em.getTransaction().commit();
        //fecha conexão
        em.close();
    }
}
