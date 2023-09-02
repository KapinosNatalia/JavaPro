/*
Класс Producer:
Представляет производителя товаров.
Содержит поле warehouse для связи с объектом Warehouse.
Метод produceItems(int amount): Добавляет указанное количество товаров на склад, используя метод produce склада.
 */
public class Producer {
    private final Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void produceItems(int amount) {
        warehouse.produce(amount);
    }
}
