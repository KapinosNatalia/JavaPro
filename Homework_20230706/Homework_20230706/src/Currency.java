import java.util.Random;

public enum Currency {
    USD,
    EUR,
    PLN;

    public static Currency randomCurrency()  {
        Random random = new Random();
        Currency[] currency = values();
        return currency[random.nextInt(currency.length)];
    }
}
