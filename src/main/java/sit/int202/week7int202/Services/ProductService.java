package sit.int202.week7int202.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int202.week7int202.entities.Product;
import sit.int202.week7int202.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String productCode) {
        return productRepository.findById(productCode).orElse(null);
    }

    public List<Product> findProductByText(String searchParam) {
        String keyword = "%" + searchParam + "%";
        return productRepository.findAllProductsByKeyword(keyword);
    }

    public List<Product> filterProductByPrice(double lowerPrice, double upperPrice) {
        if (lowerPrice > upperPrice) {
            double temp = lowerPrice;
            lowerPrice = upperPrice;
            upperPrice = temp;
        }
        System.out.println(BigDecimal.valueOf(lowerPrice) + " " +  BigDecimal.valueOf(upperPrice));
        return productRepository.findProductsByBuyPriceGreaterThanAndBuyPriceLessThanOrderByBuyPriceAsc(
                BigDecimal.valueOf(lowerPrice), BigDecimal.valueOf(upperPrice));
    }

}
