package ru.geekbrains.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.webapp.model.Product;
import ru.geekbrains.webapp.repositories.ProductRepository;

import java.util.List;


@Component
public class ProductsService {

    private ProductRepository productRepository;


    @Autowired
    public ProductsService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    public List<Product> findAll(){

      return   productRepository.findAll();
    }


    public void save(Product product){

        productRepository.save(product);
    }


    public Product findById(Long id){
        return productRepository.findById(id);

    }

    public int changePrice(int price){
        return productRepository.changePrice(price);
    }
}
