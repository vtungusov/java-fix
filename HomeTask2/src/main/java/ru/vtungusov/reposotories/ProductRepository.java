package ru.vtungusov.reposotories;

import ru.vtungusov.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> getByName(String name);
    void save(Product product);
    boolean deleteByName(String name);
    boolean isExist(String name);
    void update(String name, int price, int amount);
}
