public class Car {
    // Написать класс машина у которой будут поля цвет, булеан-спортивная или нет, энам марка и инт максимальная скорость
    private String color;
    private boolean isSportCar;
    private Brand brand;
    private int maxSpeed;

    public Car(String color, boolean isSportCar, Brand brand, int maxSpeed) {
        this.color = color;
        this.isSportCar = isSportCar;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", isSportCar=" + isSportCar +
                ", brand=" + brand +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public String getColor() {
        return color;
    }

    public boolean isSportCar() {
        return isSportCar;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
