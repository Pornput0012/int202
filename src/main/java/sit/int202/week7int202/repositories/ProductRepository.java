package sit.int202.week7int202.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sit.int202.week7int202.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findProductsByProductNameContainingOrProductVendorContainingOrProductLine_ProductLine(String productName, String vendor, String productLine);

    @Query("select p from Product p " +
            "where p.productName like ?1 or " +
            "p.productVendor like ?1 or " +
            "p.productLine.productLine like ?1")
    List<Product> findAllProductsByKeyword(String text);

    List<Product> findProductsByBuyPriceGreaterThanAndBuyPriceLessThanOrderByBuyPriceAsc(BigDecimal min, BigDecimal max);

}
