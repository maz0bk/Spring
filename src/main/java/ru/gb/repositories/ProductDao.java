package ru.gb.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.entities.Product;
import ru.gb.service.DateBaseConnection;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDao {
    private EntityManager entityManager;


    public ProductDao(DateBaseConnection dateBaseConnection) {
        this.entityManager = dateBaseConnection.getEntityManager();
    }

    public Product findById(int id){
        return entityManager.find(Product.class,id);

    }
    public List<Product> findAll(){
       return entityManager
                .createQuery("select product from Product as product", Product.class)
                .getResultList();
    }
    public void deleteById(int id){
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Product where id= :id").setParameter("id",id).executeUpdate();
        entityManager.getTransaction().commit();

    }
    public Product saveOrUpdate(Product product){
        entityManager.getTransaction().begin();
        if (product.getId()==0){
            entityManager.persist(product);}
        else
            entityManager.merge(product);
        entityManager.getTransaction().commit();
        return product;
    }
}
