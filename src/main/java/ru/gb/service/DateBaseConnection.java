package ru.gb.service;

import lombok.Getter;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
@Getter
public class DateBaseConnection {

   private EntityManager entityManager;

    public DateBaseConnection() {
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        entityManager = factory.createEntityManager();
    }

    public EntityManager connect(){
        return entityManager;
    }
}
