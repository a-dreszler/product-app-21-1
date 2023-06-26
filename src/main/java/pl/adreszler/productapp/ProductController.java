package pl.adreszler.productapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Set;

@Controller
class ProductController {

    private ProductRepository productRepository;
    private ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/lista")
    String list(@RequestParam(required = false, name = "kategoria") Category category,
                Model model) {
        Set<Product> products;

        if (category != null) {
            model.addAttribute("category", category);
            products = productRepository.findByCategory(category);
        } else {
            products = productRepository.findAll();
        }
        BigDecimal sumOfPrices = productService.sumPrices(products);

        model.addAttribute("products", products);
        model.addAttribute("sumOfPrices", sumOfPrices);
        return "list";
    }
}
