package pl.adreszler.productapp;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
class ProductService {

    BigDecimal sumPrices(Set<Product> products) {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
