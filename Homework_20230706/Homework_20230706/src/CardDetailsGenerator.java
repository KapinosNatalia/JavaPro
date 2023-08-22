import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class CardDetailsGenerator {
    public static String generateCardDetails() {
        //        Данные карты должны быть стрингой вида
        //
        //
        //        12345678123456780000999
        //        Первые 16 цифр это номер
        //        Потом дата месяцгод
        //        Потом си Ви Ви код
        return generateCardNumber() + generateExpired() + generateCVV();
    }

    private static String generateCardNumber() {
        Random random = new Random();
        int number1 = random.nextInt(4, 6); // 4 - VISA, 5 - MasterCard, Maestro
        int number2_6 = random.nextInt(10000, 99999); // Цифры со 2 по 6 включительно — идентификатор эмитента карты
        int number7_15 = random.nextInt(100000000, 999999999); // Цифры с 7 по 15 - идентификатор клиента
        int number16 = random.nextInt(1,10);// 16 цифра - контрольная, но считать ничего не будем))
        return Integer.toString(number1) + Integer.toString(number2_6) + Integer.toString(number7_15) + Integer.toString(number16);
    }

    private static String generateExpired() {
        Random random = new Random();
        int number1_2 = random.nextInt(1, 13); // 12 месяцев

        SimpleDateFormat formatter = new SimpleDateFormat("yy");
        Date dt = new Date();
        int year = Integer.parseInt(formatter.format(dt));
        int number3_4 = random.nextInt(year -2, year + 3); // чтобы срок действия мог быть и меньше, и больше текущей даты

        return String.format("%02d", number1_2) + Integer.toString(number3_4);
    }

    private static String generateCVV() {
        Random random = new Random();
        return Integer.toString(random.nextInt(0, 10)) + Integer.toString(random.nextInt(0, 10)) + Integer.toString(random.nextInt(0, 10));
    }

    public static double generateBalance() {
        Random random = new Random();
        double balance = random.nextDouble(0, 25000);
        MathContext mathContext = new MathContext(15, RoundingMode.HALF_UP); // для double
        BigDecimal bigDecimal = new BigDecimal(balance, mathContext);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        return bigDecimal.doubleValue();
    }
}
