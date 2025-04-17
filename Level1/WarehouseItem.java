import java.util.ArrayList;
import java.util.List;

public abstract class WarehouseItem{
    String name;
    double price;

    public WarehouseItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Storage<T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

class Utilities{
    public static void displayItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            System.out.println(item.getName());
            System.out.println(item.getPrice());
        }
    }
}

class Electronics extends WarehouseItem{
    public Electronics(String name, double price){
        super(name, price);
    }
}

class Groceries extends WarehouseItem{
    public Groceries(String name, double price){
        super(name, price);
    }
}

class Furniture extends WarehouseItem{
    public Furniture(String name, double price){
        super(name, price);
    }
}

class Main{
    public static void main(String[] args){
        Storage<WarehouseItem> storage = new Storage<>();
        Electronics phone = new Electronics("iPhone 13", 15000);
        Groceries vegetable = new Groceries("Cabbage", 10);
        Furniture furniture = new Furniture("Chair", 20);

        storage.addItem(phone);
        storage.addItem(vegetable);
        storage.addItem(furniture);

        Utilities.displayItems(storage.getItems());
    }
}