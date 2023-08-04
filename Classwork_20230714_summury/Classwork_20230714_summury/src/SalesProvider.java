import java.time.ZonedDateTime;
import java.util.List;

public interface SalesProvider {
    List<Sale> getSales(ZonedDateTime from, ZonedDateTime to);
}
