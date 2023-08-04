import java.math.BigDecimal;

public class Sale {
    private final String article;
    private final int count;
    private final BigDecimal sum;

    public Sale(String article, int count, BigDecimal sum) {
        this.article = article;
        this.count = count;
        this.sum = sum;
    }

    public String getArticle() {
        return article;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getSum() {
        return sum;
    }
}
