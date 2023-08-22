import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private Map<Client, Double> clientMap;

    private static Storage storage;

    private Storage() {

    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void setClientMap(Map<Client, Double> clientMap) {
        storage.clientMap = clientMap;
    }

    //Выводят всех клиентов у которых определенный статус карты
    public void getClientsWithStatus(Status status) {
        System.out.println(clientMap.keySet().stream()
                .filter(client -> client.getBankCard().getStatus().equals(status))
                .map(Client::getName)
                .toList());
    }

    //Группируют по балансу у кого больше или меньше какой-то суммы
    public void groupByBalance(double sum) {
        System.out.println("-------------------------");
        System.out.println("Сумма больше " + sum);
        Map<Boolean, List<Map.Entry<Client, Double>>> map =
        clientMap.entrySet().stream()
                .collect(Collectors.groupingBy(clientDoubleEntry -> clientDoubleEntry.getValue() > sum));
        System.out.println(map);
        map.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": ");
                    System.out.println(entry.getValue().stream()
                            .map(entryCD -> "Client: " + entryCD.getKey().getName() + ", balance: " + entryCD.getValue())
                            .toList());
                });

    }

    //Средний баланс по клиентам
    public double averageBalance() {
        return clientMap.entrySet().stream()
                .mapToDouble(value -> value.getValue())
                .average().getAsDouble();
    }

    //Выводят только номера карт всех клиентов в формате имя номер
    public void cardNumbers() {
        System.out.println("----------------------");
        System.out.println("Имя клиента и номер карты:");
        System.out.println(clientMap.keySet().stream()
                .map(client -> client.getName() + ": " + client.getBankCard().getCardDetails().substring(0, 16))
                .toList());
    }

    //        Выводят всех клиентов в у кого закончился срок действия карт

    //        Сортируют по балансу
    public void sortByBalance() {
        System.out.println("----------------------");
        System.out.println("Сортировка по балансу:");
        System.out.println(clientMap.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    if (entry1.getValue() - entry2.getValue() > 0) return 1;
                    else if (entry1.getValue() - entry2.getValue() < 0) return -1;
                    else return 0;
                })
                .toList());
    }

    //        Группируют у кого закончился срок карт, а у кого нет
    public void groupingIsExpired() {
        System.out.println("----------------------");
        System.out.println("Группировка у кого закончился срок карт, а у кого нет:");
        System.out.println(clientMap.keySet().stream()
                .collect(Collectors.groupingBy(client -> Status.EXPIRED.equals(client.getBankCard().getStatus()))));
    }

}
