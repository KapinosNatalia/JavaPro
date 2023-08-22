public class Client {
    private String name;
    private BankCard bankCard;
    private double accountBalance;

    public Client(String name, BankCard bankCard, double accountBalance) {
        this.name = name;
        this.bankCard = bankCard;
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    @Override
    public String toString() {
        return '\n' + "Client{" +
                "name='" + name + '\'' +
                ", bankCard=" + bankCard +
                ", accountBalance=" + accountBalance +
                '}' + '\n';
    }
}
