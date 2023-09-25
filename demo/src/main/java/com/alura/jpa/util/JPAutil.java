package com.alura.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja_virtual");

    public static EntityManager getEntityMenager(){
        return FACTORY.createEntityManager();
        
    }
    
}
