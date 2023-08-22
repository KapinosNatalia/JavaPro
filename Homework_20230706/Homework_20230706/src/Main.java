import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Создать класс Банковская карта
//        В этом классе должны быть поля: Данные карты, Валюта, Статус
//
//        Все что с большой буквы это классы
//
//
//        Сделать класс ГенераторДанныхБанковчкойКарты который будет возвращать Данные Карты
//        Данные карты давайте будет просто Стринга
//
//
//        Данные карты должны быть стрингой вида
//
//
//        12345678123456780000999
//        Первые 16 цифр это номер
//        Потом дата месяцгод
//        Потом си Ви Ви код
//
//
//        Создать класс Клиент у которого есть Имя и Карта и баланс
//        Создать класс Хранилище где в мапе будут храниться минимум 25 Клиентов
//        Ключ это Клиент а значение его баланс

        double balance;
        Map<Client, Double> clientDoubleMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            balance = CardDetailsGenerator.generateBalance();
            String cardDetails = CardDetailsGenerator.generateCardDetails();
            int month = Integer.parseInt(cardDetails.substring(16,18));
            int year = Integer.parseInt(cardDetails.substring(18,20));
            clientDoubleMap.put(new Client(NameGenerator.generateMenName(), new BankCard(cardDetails, Currency.randomCurrency(), Status.getStatus(month, year)), balance), balance);
        }
        for (int i = 0; i < 4; i++) {
            balance = CardDetailsGenerator.generateBalance();
            clientDoubleMap.put(new Client(NameGenerator.generateWomanName(), new BankCard(CardDetailsGenerator.generateCardDetails(), Currency.randomCurrency(), Status.randomStatus()), balance), balance);
        }
        System.out.println(clientDoubleMap);
        Storage storage = Storage.getInstance();
        storage.setClientMap(clientDoubleMap);

        //        Выводять всех клиентов у которых определенный статус карты
        System.out.println('\n' + "ACTIVE cards:" + '\n');
        storage.getClientsWithStatus(Status.ACTIVE);
        System.out.println('\n' + "BLOCKED cards:" + '\n');
        storage.getClientsWithStatus(Status.BLOCKED);
        System.out.println('\n' + "EXPIRED cards:" + '\n');
        storage.getClientsWithStatus(Status.EXPIRED);

        //        Группируют по балансу у кого больше или меньше какой-то суммы
        storage.groupByBalance(20000);

        //        Средний баланс по клиентам
        System.out.println("Average balance: " + storage.averageBalance());

        //        Выводят только номера карт всех клиентов в формате имя номер
        storage.cardNumbers();

        //        Выводят всех клиентов в у кого закончился срок действия карт
        storage.getClientsWithStatus(Status.EXPIRED);

        //        Сортируют по балансу
        storage.sortByBalance();

        //        Группируют у кого закончился срок карт, а у кого не
        storage.groupingIsExpired();
    }
}
