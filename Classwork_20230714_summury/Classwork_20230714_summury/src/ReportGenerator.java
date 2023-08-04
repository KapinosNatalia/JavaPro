import java.time.ZonedDateTime;

public interface ReportGenerator {
    ReportResult generateReport(ZonedDateTime from, ZonedDateTime to);
}
