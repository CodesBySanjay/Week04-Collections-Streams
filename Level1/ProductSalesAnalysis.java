import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double revenue;

    ProductSales(String productId, double revenue) {
        this.productId = productId;
        this.revenue = revenue;
    }
}

public class ProductSalesAnalysis {
    public static List<ProductSales> analyze(List<Sale> sales) {
        return sales.stream()
            .filter(s -> s.quantity > 10)
            .map(s -> new ProductSales(s.productId, s.quantity * s.price))
            .sorted(Comparator.comparingDouble(p -> -p.revenue))
            .limit(5)
            .collect(Collectors.toList());
    }
}
