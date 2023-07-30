import java.util.Random;

public enum Brand {
    AUDI,
    BMW,
    VW,
    Mazda;

    public static Brand getRandomBrand() {
        Random random = new Random();
        return Brand.values()[random.nextInt(0, 4)];
    }
}
