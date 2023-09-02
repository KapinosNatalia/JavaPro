/*
Класс Consumer:
Представляет потребителя товаров.
Содержит поле warehouse для связи с объектом Warehouse.
Метод consumeItems(int amount): Забирает указанное количество товаров со склада, используя метод consume склада.
 */
public class Consumer {
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void consumeItems(int amount) {
        warehouse.consume(amount);
    }
}
