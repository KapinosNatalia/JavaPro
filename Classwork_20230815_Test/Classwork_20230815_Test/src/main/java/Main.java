//Классы:
//        Person:
//        Поля:
//        String name
//        int age
//        String address
//        String email
//        Методы:
//
//        Конструктор с параметрами для инициализации полей.
//        String getSummary() - возвращает строку, содержащую информацию о человеке (имя, возраст, адрес).
//        boolean isAdult() - проверяет, является ли человек совершеннолетним (возраст >= 18).
//        void sendEmail(String message) - имитирует отправку электронной почты.
//
//
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
//
//
//        Order:
//        Поля:
//        int orderId
//        Person customer
//        List<Product> products
//        LocalDate orderDate
//        Методы:
//
//        Конструктор с параметрами для инициализации полей.
//        double calculateTotalPrice() - вычисляет общую стоимость заказа на основе продуктов.
//        int getNumberOfProducts() - возвращает количество продуктов в заказе.
//        boolean isOrderExpired() - проверяет, истекла ли дата заказа.
//
//
//        OrderProcessor:
//        Поля:
//        List<Order> orders
//        Методы:
//
//        Конструктор без параметров.
//        void addOrder(Order order) - добавляет заказ в список заказов.
//        double calculateTotalRevenue() - вычисляет общую выручку от всех заказов.
//        List<Order> getExpiredOrders() - возвращает список заказов, у которых истекла дата.
public class Main {
}

/*
* @Mock
    Person person;

    @InjectMocks
    Order order;

    @Test
    void calculateTotalPrice() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", 10.0,15,"category"));
        products.add(new Product("Product2", 20.0,16,"category"));
        products.add(new Product("Product3", 15.0,20,"category"));

        Order order = new Order(1,person,products, LocalDate.now());

        double expectedTotalPrice = 10.0 + 20.0 + 15.0;
        double actualTotalPrice = order.calculateTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice, 0.001);
    }
* */