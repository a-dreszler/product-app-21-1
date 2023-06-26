package pl.adreszler.productapp;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
class ProductRepository {

    private final Set<Product> products = new HashSet<>();

    public ProductRepository() {
        addProduct("Czekolada milka", Category.GROCERY, BigDecimal.valueOf(3.99));
        addProduct("Mleko mlekovita 3.2%", Category.GROCERY, BigDecimal.valueOf(3.29));
        addProduct("Cukier Diamant", Category.GROCERY, BigDecimal.valueOf(4.99));
        addProduct("Rękawiczki do sprzątania Jan Niezbędny", Category.HOUSEHOLD, BigDecimal.valueOf(4.99));
        addProduct("Płyn do naczyń Ludwik miętowy", Category.HOUSEHOLD, BigDecimal.valueOf(2.99));
        addProduct("Opel w gazie", Category.DIFFERENT, BigDecimal.valueOf(14999.99));
    }

    void addProduct(String name, Category category, BigDecimal price) {
        products.add(new Product(name, category, price));
    }

    public Set<Product> findAll() {
        return products;
    }

    Set<Product> findByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .collect(Collectors.toSet());
    }
}
