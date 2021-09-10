package ru.gb.service;

import lombok.Getter;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import ru.gb.entities.Customer;
import ru.gb.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class DateBaseConnection {

   private EntityManager entityManager;

    public DateBaseConnection() {
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        entityManager = factory.createEntityManager();

    }

    public void testCreation() {
        entityManager.getTransaction().begin();
        Product p = new Product();
        p.setName("cake11");
        p.setPrice(379.00);
        entityManager.persist(p);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Customer c = new Customer();
        c.setName("Vasya11");
        entityManager.persist(c);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        c.setProductList(new ArrayList<>(List.of(p)));
        entityManager.merge(c);
        entityManager.getTransaction().commit();


    }

    public EntityManager connect(){
        return entityManager;
    }
}
