package ru.gb.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.entities.Customer;
import ru.gb.entities.Product;
import ru.gb.service.DateBaseConnection;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDao {
    private EntityManager entityManager;
    public CustomerDao(DateBaseConnection dateBaseConnection){
        entityManager = dateBaseConnection.getEntityManager();
    }
    public Customer findById(int id){
        return entityManager.find(Customer.class, id);
    }
    public List<Customer> findAll(){
        return entityManager
                .createQuery("select c from Customer as c", Customer.class)
                .getResultList();
    }
    public List<Product> findCustomerProducts(int id){
        return findById(id).getProductList();
    }
}
