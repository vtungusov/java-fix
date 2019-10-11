package ru.vtungusov.reposotories;

import ru.vtungusov.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public List<Product> products() {
        return products;
    }

    private static Storage instance;

    static {
        instance = new Storage();
    }

    private List<Product> products;

    private Storage() {
        this.products = new ArrayList<>();
        products.add(new Product("Tomato", 15, 800));
        products.add(new Product("Airplane", 150000, 1));
        products.add(new Product("Knife", 150, 20));
    }

    public static Storage getInstance() {
        return instance;
    }
}
