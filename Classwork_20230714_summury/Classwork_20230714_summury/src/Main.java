import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * Starta Institute 22 12:00
         * * 2. Нужно написать модуль программы по составлению отчета по продажам за выбранные даты.
         *      * Продажа представляет собой: артикул, количество и стоимость.
         *      * Отчет должен отображать: самый продаваемый артикул и общую стоимость всех продаж по каждому артикулу.
         *      * Желаемый интерфейс:
         *      * <p>
         *      * interface ReportGenerator {
         *      *     ReportResult generateReport(ZonedDateTime from, ZoneDateTime to);
         *      * }
         *
         *      * <p>
         *      * Примечание:
         *      * а) при этом выгрузкой информации по продажам занимается другая команда, которая пока ещё не передала вам
         *      * информацию как в вашем модуле получать сами заказы. Обойдите это ограничение.
         *      * б) ZonedDateTime можно создать с помощью:
         *      * LocalDate.parse("2023-06-01").atStartOfDay(ZoneId.of("Europe/Berlin"));
         *      * c) В классе Продажа дата не нужна!
         */
        SalesProvider salesProvider = (from, to) -> {
            if (from.isAfter(to)) {
                return Collections.emptyList();
            }
            return List.of(new Sale("Milk", 1, new BigDecimal(2)),
                    new Sale("Milk", 2, new BigDecimal(2)),
                    new Sale("Potato", 3, new BigDecimal(2)),
                    new Sale("Bread", 2, new BigDecimal(2)),
                    new Sale("Milk", 1, new BigDecimal(2)));
        };

        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl(salesProvider);
        ReportResult reportResult = reportGenerator.generateReport(LocalDate.parse("2023-06-01").atStartOfDay(ZoneId.of("Europe/Berlin")), LocalDate.parse("2023-06-02").atStartOfDay(ZoneId.of("Europe/Berlin")));
        System.out.println(reportResult);
    }
}
