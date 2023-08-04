import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = Faker.instance();
        System.out.println(faker.address().cityName());
        System.out.println(faker.address().cityName());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.business().creditCardType());
    }
}
