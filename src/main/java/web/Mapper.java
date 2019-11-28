package web;

import com.javaguru.shoppinglist.ApplicationConfiguration;
import com.javaguru.shoppinglist.Product;
import com.javaguru.shoppinglist.ProductService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class Mapper {
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    ProductService productService = context.getBean(ProductService.class);

    @RequestMapping("/get-product")
    public String getProduct(@RequestParam int id) {
        Product product = productService.retrieveProduct(id);
        return product.toString();
    }

    @RequestMapping("/create-product")
    public String createProduct(@RequestParam String name,
                              @RequestParam String category,
                              @RequestParam String description,
                              @RequestParam BigDecimal price,
                              @RequestParam BigDecimal discount) {
        Product product = new Product();
        productService.assignProductName(product, name);
        productService.assignProductCategory(product, category);
        productService.assignProductDescription(product, description);
        productService.assignProductPrice(product, price);
        productService.assignProductDiscount(product, discount);
        productService.saveProduct(product);
        return String.valueOf(product.getId());
    }
}
