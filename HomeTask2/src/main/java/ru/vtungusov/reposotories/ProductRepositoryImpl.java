package ru.vtungusov.reposotories;

import ru.vtungusov.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.vtungusov.reposotories.Storage.getInstance;

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;

    public ProductRepositoryImpl() {
        products = getInstance().products();
        this.products = new ArrayList<>();
        this.products.add(new Product("Tomato", 15, 800));
        this.products.add(new Product("Airplane", 150000, 1));
        this.products.add(new Product("Knife", 150, 20));
    }

    @Override
    public List<Product> findAll() {
        return this.products;
    }

    @Override
    public Optional<Product> getByName(String name) {
        for (Product product : this.products) {
            if (product.getName().equals(name))
                return Optional.of(product);
        }
        return Optional.empty();
    }

    @Override
    public void save(Product product) {
        this.products.add(product);
    }

    @Override
    public boolean deleteByName(String name) {
        for (Product product : this.products) {
            if (product.getName().equals(name)) {
                this.products.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isExist(String name) {
        for (Product product : this.products) {
            if (product.getName().equals(name))
                return true;
        }
        return false;
    }
}
