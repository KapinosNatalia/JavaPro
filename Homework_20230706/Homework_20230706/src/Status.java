import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public enum Status {
    ACTIVE,
    BLOCKED,
    EXPIRED;

    public static Status getStatus(int cardMonth, int cardYear){
        SimpleDateFormat formatter = new SimpleDateFormat("yy");
        Date dt = new Date();
        int currentYear = Integer.parseInt(formatter.format(dt));
        int currentMonth = LocalDate.now().getMonthValue();
        if (currentYear > cardYear || (currentYear == cardYear && currentMonth > cardMonth)) {
            return EXPIRED;
        } else {
            return randomStatus();
        }
    }
    public static Status randomStatus()  {
        Random random = new Random();
        Status[] status = values();
        return status[random.nextInt(status.length - 1)];
    }
}
