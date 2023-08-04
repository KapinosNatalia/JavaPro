import java.math.BigDecimal;
import java.util.Map;

public class ReportResult {
    // Отчет должен отображать: самый продаваемый артикул и общую стоимость всех продаж по каждому артикулу.
    private final String article;
    private final Map<String, BigDecimal> prices;

    public ReportResult(String article, Map<String, BigDecimal> prices) {
        this.article = article;
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "ReportResult{" +
                "article='" + article + '\'' +
                ", prices=" + prices +
                '}';
    }
}
