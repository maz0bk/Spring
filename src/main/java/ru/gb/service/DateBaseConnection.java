package ru.gb.service;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class DateBaseConnection {
    public EntityManager connect(){
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        return factory.createEntityManager();
    }
}
