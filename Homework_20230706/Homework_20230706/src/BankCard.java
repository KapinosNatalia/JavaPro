public class BankCard {
    private String CardDetails;
    private Currency currency;
    private Status status;

    public BankCard(String cardDetails, Currency currency, Status status) {
        CardDetails = cardDetails;
        this.currency = currency;
        this.status = status;
    }

    public String getCardDetails() {
        return CardDetails;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "CardDetails='" + CardDetails + '\'' +
                ", currency=" + currency +
                ", status=" + status +
                '}';
    }
}
