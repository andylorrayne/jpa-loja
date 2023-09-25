package com.alura.jpa.testes;

import javax.persistence.EntityManager;

import com.alura.jpa.modelo.Categoria;
import com.alura.jpa.modelo.Produto;
import com.alura.jpa.util.JPAutil;
import com.alura.jpa.dao.CategoriaDao;
import com.alura.jpa.dao.ProdutoDao;


public class CadastroDeProdutos {
    public static void main(String[] args) {


        Categoria eletrodomestico = new Categoria("ELETRONOMESTICO");

        Produto celular = new Produto("ELETROLUX MAQUINA DE LAVAR", "MAQUINA DE LAVAR", 2500.00, eletrodomestico);
        
        //aqui é onde criamos a conexão, e usamos padrao de projeto FACTORY
        //EntityManagerFactory  factory = Persistence.createEntityManagerFactory("loja_virtual");
       // EntityManager em = factory.createEntityManager();

        EntityManager em = JPAutil.getEntityMenager(); //substitui o codigo acima

        CategoriaDao cdao = new CategoriaDao();
        ProdutoDao dao = new ProdutoDao();
        cdao.CategoriaDao(em);
        dao.ProdutoDao(em);
        //abre a conexao
        em.getTransaction().begin();

        

        //executa a ação desejada
        cdao.cadastrar(eletrodomestico);
        dao.cadastrar(celular);;

        //envia e salva as inf
        em.getTransaction().commit();
        //fecha conexão
        em.close();

    }
}
