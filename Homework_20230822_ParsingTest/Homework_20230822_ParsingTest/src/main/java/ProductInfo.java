import java.util.Objects;

public class ProductInfo {
    private final int id;
    private final String category; // - это группа продуктов. Например, сладкое, вода, мясо итд.
    private final String name; // - название продукта. Например "Шоколад Аленка", "Батон нарезной" или "Фарш говяжий" итд.
    private final String factory; // - Производитель товара, например "MARS", "Dirol Cadberry" итд.
    private final int quantity; // - количество товара на складе, если товар весовой то в килограммах, если в упаковке то в штуках. Например "Coca Cola 0.33" 15000 банок или "Печенье Мария" - 500 кг.
    private final boolean isPacked; // - если товар продается в упаковке то значение true, если нет то false.
    private final boolean isAdv; // - участвует ли в какой либо акционной программе. Если да то true если нет то false.
    private final double price; // - цена за единицу если ISPACKED - true, за килограмм если ISPACKED - false.
    private final double margin; // - процент прибыли с единицы товара если в упаковке и с килограмма если продается на вес. Диапазон от 1,5% до 24% включительно. % может быть округлен до сотых.
    private final boolean isDebt; // - должна ли магазину какая-либо FACTORY.

    public ProductInfo(int id, String category, String name, String factory, int quantity, boolean isPacked, boolean isAdv, double price, double margin, boolean isDebt) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.factory = factory;
        this.quantity = quantity;
        this.isPacked = isPacked;
        this.isAdv = isAdv;
        this.price = price;
        this.margin = margin;
        this.isDebt = isDebt;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getFactory() {
        return factory;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isPacked() {
        return isPacked;
    }

    public boolean isAdv() {
        return isAdv;
    }

    public double getPrice() {
        return price;
    }

    public double getMargin() {
        return margin;
    }

    public boolean isDebt() {
        return isDebt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\nProductInfo{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", factory='" + factory + '\'' +
                ", quantity=" + quantity +
                ", isPacked=" + isPacked +
                ", isAdv=" + isAdv +
                ", price=" + price +
                ", margin=" + margin +
                ", isDebt=" + isDebt +
                '}';
    }
}
