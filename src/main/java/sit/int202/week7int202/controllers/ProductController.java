package sit.int202.week7int202.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sit.int202.week7int202.Services.ProductService;
import sit.int202.week7int202.entities.Product;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product_list";
    }

    @GetMapping("/search-product")
    public String searchProduct(@RequestParam String searchParam, Model model) {
        List<Product> products = productService.findProductByText(searchParam);
        model.addAttribute("products", products);
        return "product_list";
    }

    @GetMapping("/search-product-by-price")

    public String searchProductByPrice(@RequestParam(defaultValue = "10.0") Double lowerPrice,
                                       @RequestParam(defaultValue = "9999.0") Double upperPrice, Model model) {
        List<Product> products = productService.filterProductByPrice(lowerPrice, upperPrice);

        model.addAttribute("products", products);
        return "product_list";
    }
}