package ru.geekbrains.webapp.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.webapp.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct

    public void init(){

        this.products=new ArrayList<>(Arrays.asList(

                new Product(1L,"Apple", 20),
                new Product(2L,"Cheese", 20),
                new Product(3L,"Juice", 20),
                new Product(4L,"Bread", 20)

        ));
    }


    public List<Product>findAll(){

        return Collections.unmodifiableList(products);

    }

    public void save(Product product){
        products.add(product);
    }


    public Product findById(Long id){

        return products.stream().filter(p->p.getId().equals(id)).findFirst().get();
    }
}
