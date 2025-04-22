import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
    private HashMap<String, Double> productPrices;
    private LinkedHashMap<String, Integer> cart;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();
    }

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        }
    }

    public void displayCart() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            System.out.println(product + " - Quantity: " + quantity + ", Price per item: " + price);
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Double, List<String>> priceMap = new TreeMap<>();
        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            priceMap.putIfAbsent(price, new ArrayList<>());
            priceMap.get(price).add(product);
        }
        for (Map.Entry<Double, List<String>> entry : priceMap.entrySet()) {
            double price = entry.getKey();
            List<String> products = entry.getValue();
            for (String product : products) {
                System.out.println(product + " - Price: " + price);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.0);
        cart.addProduct("Banana", 0.5);
        cart.addProduct("Orange", 0.8);

        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 5);
        cart.addToCart("Orange", 3);

        System.out.println("Cart Items:");
        cart.displayCart();

        System.out.println("\nCart Items Sorted by Price:");
        cart.displaySortedByPrice();
    }
}