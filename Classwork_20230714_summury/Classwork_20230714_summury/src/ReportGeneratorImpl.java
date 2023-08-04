import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator{

    private final SalesProvider salesProvider;

    public ReportGeneratorImpl(SalesProvider salesProvider) {
        this.salesProvider = salesProvider;
    }

    @Override
    public ReportResult generateReport(ZonedDateTime from, ZonedDateTime to) {
        List<Sale> sales = getSales(from, to);
        Map<String, Integer> articleToCount = sales.stream()
                .collect(Collectors.toMap(sale -> sale.getArticle(), sale -> sale.getCount(), (oldValue, newValue) -> Integer.sum(oldValue, newValue)));

        String mostSoldArticle = articleToCount.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                //.get()
                //.getKey();
                .map(Map.Entry::getKey)
                .orElse(null);

        Map<String, BigDecimal> articleToPrice = getSales(from, to).stream()
                .collect(Collectors.toMap(Sale::getArticle, Sale::getSum,
                        BigDecimal::add));

        return new ReportResult(mostSoldArticle, articleToPrice);
    }

    private List<Sale> getSales(ZonedDateTime from, ZonedDateTime to) {
        return salesProvider.getSales(from, to);
    }
}
