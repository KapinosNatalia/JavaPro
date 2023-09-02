/*
Класс Warehouse:
Обеспечивает хранение и управление товарами на складе.
Содержит поле capacity для ограничения вместимости склада.
Содержит поле availableItems для отслеживания доступного количества товаров на складе.
Метод produce(int amount): Добавляет заданное количество товаров на склад.
Если нет места на складе, блокирует поток до освобождения места.
Метод consume(int amount): Изымает заданное количество товаров со склада.
Если товаров недостаточно, блокирует поток до появления достаточного количества товаров.
 */
public class Warehouse {
    private final int capacity;
    private volatile int availableItems;

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int amount) {
        System.out.println("Producer + " + Thread.currentThread().getName() + " want to put " + amount + ". Capacity is " + capacity + ", availability: " + availableItems);
        if (availableItems + amount <= capacity) {
            availableItems += amount;
            System.out.println("Producer + " + Thread.currentThread().getName() + " put " + amount + ". Available items " + availableItems);
            notifyAll();
        } else {
            while (availableItems + amount >= capacity) {
                int part = capacity - availableItems;
                amount -= part;
                availableItems += part;
                System.out.println("Producer + " + Thread.currentThread().getName() + " put only part " + part + ", still left " + amount + ". Available items " + availableItems);
                try {
                    System.out.println("Producer + " + Thread.currentThread().getName() + " is waiting");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            availableItems += amount;
            System.out.println("Producer + " + Thread.currentThread().getName() + " put " + amount + ". Available items " + availableItems);
            notifyAll();
        }
    }

    public synchronized void consume(int amount) {
        System.out.println("Consumer + " + Thread.currentThread().getName() + " want to take " + amount + ". Capacity is " + capacity + ", availability: " + availableItems);
        while (availableItems < amount) {
            try {
                System.out.println("Consumer + " + Thread.currentThread().getName() + " is waiting");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        availableItems -= amount;
        System.out.println("Consumer + " + Thread.currentThread().getName() + " took " + amount + ". Available items " + availableItems);
        notifyAll();
    }

    public String getInfo() {
        return "availableItems = " + availableItems;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "capacity=" + capacity +
                ", availableItems=" + availableItems +
                '}';
    }
}
