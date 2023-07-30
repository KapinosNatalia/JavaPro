import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class Generator {
    /**
     * Написать класс Генератор которые генерирует Девелоперов и Машины
     * у генератора будут два метода которые будут генерировать машины и девелоперов в зависимости от количества которые вы передадите в параметры
     * Вам в помощ библиотека faker для генерации любых имен, фамилий итд
     */

    static Faker faker = Faker.instance();
    static Random random = new Random();

    private static Car generateCar() {
//        Faker faker = Faker.instance();
//        Random random = new Random();

        String color = faker.color().name();
        boolean isSportCar = random.nextBoolean();
        Brand brand = Brand.getRandomBrand();
        int maxSpeed = random.nextInt(90, 200);

        return new Car(color, isSportCar, brand, maxSpeed);
    }

    private static Developer generateDeveloper() {
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        int age = random.nextInt(18, 99);
        double salary = (double) Math.round(random.nextDouble(1000, 8000)*100)/100;

        char gender;
        boolean isMan = random.nextBoolean();
        if (isMan) {
            gender = 'm';
        }
        else {
            gender = 'f';
        }

        Car car = generateCar();
        return new Developer(firstname, lastname, age, salary, gender, car);
    }

    public static ArrayList<Developer> generateDevelopersAndCars(int numberOfValues) {
        ArrayList<Developer> listOfDevelopers = new ArrayList<>();
        for (int i = 0; i < numberOfValues; i++) {
            listOfDevelopers.add(generateDeveloper());
        }
        return listOfDevelopers;
    }


}
