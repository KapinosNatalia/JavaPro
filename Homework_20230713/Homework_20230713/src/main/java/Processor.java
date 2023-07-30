import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Processor {
    /*
     * Написать класс Обработчик который будет:
     * —проходится по листу девелоперов и выводить всех мужчин у которых спортивная машина
     * —группировать по полу все машины. те у мужчин такие то у женщин такие то
     * —Переводить в мапу ключ-девелопер а значение максимальная скоросьть авто
     * —записывать в текстовый файл всех девелоперов в формате : Jonn-[auto: BMW ::: salary: 12345] в столбик. Т.е в файле нужна только эта инфа
     */


    /**
     * проходится по листу девелоперов и выводить всех мужчин у которых спортивная машина
     */
    public void printMenWithSportcars(ArrayList<Developer> listOfDevelopers) {
        System.out.println("Список девелоперов-мужчин со спортивной машиной:");
        listOfDevelopers.stream()
                .filter(developer -> (developer.getGender() == 'm' && developer.getCar().isSportCar()))
                .forEach(System.out::println);
    }

    /**
     * группировать по полу все машины. те у мужчин такие то у женщин такие то
     * Сделано с подсказкой
     */
    public Map<Character, List<Car>> groupCarsByGender(ArrayList<Developer> listOfDevelopers) {
        return listOfDevelopers.stream()
                .collect(Collectors.groupingBy(developer -> developer.getGender(), Collectors.mapping(developer -> developer.getCar(), Collectors.toList())));
    }

    /**
    * Переводить в мапу ключ-девелопер а значение максимальная скоросьть авто
     */
    public  Map<Developer, Integer> generateMapDeveloperSpeed(ArrayList<Developer> listOfDevelopers) {
        return listOfDevelopers.stream()
                .collect(Collectors.toMap(developer -> developer, developer -> developer.getCar().getMaxSpeed()));
    }

    /**
     * записывать в текстовый файл всех девелоперов в формате : Jonn-[auto: BMW ::: salary: 12345] в столбик. Т.е в файле нужна только эта инфа
    */
    public void createFileWithInfo(ArrayList<Developer> listOfDevelopers) {
        try(FileWriter fileWriter = new FileWriter("listOfDevelopers.txt", false)) { // параметр false означает, что файл будет перезаписываться (по умолчанию тоже false). При true файл дозаписывается
            listOfDevelopers
                    .forEach(developer -> {if (developer != null) {
                        try {
                            fileWriter.write(developer.getFirstname() + "-[auto: " + developer.getCar().getBrand() + " ::: salary: " + developer.getSalary() + "]\n");
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                            throw new RuntimeException(e);
                        }
                    }
                    else {
                        System.out.println("null");
                    }});
            System.out.println("Файл записан");
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }        
    }

    public void printListOfDevelopers(ArrayList<Developer> listOfDevelopers) {
        System.out.println("Список девелоперов:");
        for (Developer developer: listOfDevelopers) {
            System.out.println(developer);
        }
    }
}
