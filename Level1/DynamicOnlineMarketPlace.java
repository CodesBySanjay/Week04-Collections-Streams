class Discount {
    public static <T extends Enum<T>> void applyDiscount(Product<T> product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}

class Product<T extends Enum<T>> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }
}

enum BookCategory {
    FICTION,
    NONFICTION,
    EDUCATIONAL
}

enum ClothingCategory {
    MENS,
    WOMENS,
    KIDS
}

enum GadgetCategory {
    MOBILE,
    LAPTOP,
    TABLET
}

public class DynamicOnlineMarketPlace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Basics", 500.0, BookCategory.EDUCATIONAL);
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 1200.0, ClothingCategory.MENS);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 20000.0, GadgetCategory.MOBILE);

        Discount.applyDiscount(book, 10);
        Discount.applyDiscount(shirt, 15);
        Discount.applyDiscount(phone, 20);

        System.out.println(book.getName() + " - " + book.getPrice() + " - " + book.getCategory());
        System.out.println(shirt.getName() + " - " + shirt.getPrice() + " - " + shirt.getCategory());
        System.out.println(phone.getName() + " - " + phone.getPrice() + " - " + phone.getCategory());
    }
}