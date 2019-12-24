package ru.vtungusov.reposotories;

import ru.vtungusov.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;

    public ProductRepositoryImpl() {
        products = Storage.getInstance().products();
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

    @Override
    public void update(String name, int price, int amount) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.setAmount(amount);
                product.setPrice(price);
            }
        }
    }

}
