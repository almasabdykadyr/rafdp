package store;

public class Product {

    private final String name;
    private final ProductType type;
    private final long price;

    public Product(String name, ProductType type, long price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public long getPrice() {
        return price;
    }
}
