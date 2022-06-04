package ru.geekbrains.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webapp.model.Product;
import ru.geekbrains.webapp.services.ProductsService;

import java.util.List;

@Controller
public class ProductsController {

    private ProductsService productsService;


    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    // GET http://localhost:8189/app/show_all
    @GetMapping(value = "show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products";

    }

    // GET http://localhost:8189/app/show/{id}
    @GetMapping(value = "/show/{id}")
    public String showProductPageById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productsService.findById(id));
        return "product_info";

    }

    // GET http://localhost:8189/app/add
    @GetMapping(value = "/add")
    public String addProduct() {

        return "add_product";
    }


    // POST http://localhost:8189/app/add
    @PostMapping(value = "/add")
    public String saveProduct(@RequestParam Long id, @RequestParam String name,@RequestParam int price){
        productsService.save(new Product(id, name, price));
        return "redirect:/show_all";
    }
}