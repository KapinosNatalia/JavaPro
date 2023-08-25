import java.util.Objects;

//        Product:
//        Поля:
//        String name
//        double price
//        int quantity
//        String category
//        Методы:
//
//        Конструктор с параметрами для инициализации полей.
//        double getTotalPrice() - возвращает общую стоимость продукта (цена * количество).
//        boolean isAvailable() - проверяет, доступен ли продукт для заказа (количество > 0).
//        String getCategory() - возвращает категорию продукта.
public class Product implements Comparable<Product>{
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    //- возвращает категорию продукта.
    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Product otherProduct) {
        // Сначала сравниваем по названию товаров
        int nameComparison = this.name.compareTo(otherProduct.getName());

        if (nameComparison != 0) {
            return nameComparison;
        }

        // Если названия одинаковы, сравниваем по цене
        return Double.compare(this.price, otherProduct.getPrice());
    }

    //- возвращает общую стоимость продукта (цена * количество).
    public double getTotalPrice() {
        return price * quantity;
    }


    //- проверяет, доступен ли продукт для заказа (количество > 0).
    public boolean isAvailable() {
        return quantity > 0;
    }

}
