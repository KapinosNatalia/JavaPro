import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * Написать класс машина у которой будут поля цвет, булеан-спортивная или нет, энам марка и инт максимальная скорость
         * Написать класс Девелопер у которого будет имя, фамилия , возраст, зарплата, чар- пол и машина
         * Написать класс Генератор которые генерирует Девелоперов и Машины
         * у генератора будут два метода которые будут генерировать машины и девелоперов в зависимости от количества которые вы передадите в параметры
         * Вам в помощ библиотека faker для генерации любых имен, фамилий итд
         * Написать класс Обработчик который будет:
         * —проходится по листу девелоперов и выводить всех мужчин у которых спортивная машина
         * —группировать по полу все машины. те у мужчин такие то у женщин такие то
         * —Переводить в мапу ключ-девелопер а значение максимальная скоросьть авто
         * —записывать в текстовый файл всех девелоперов в формате : Jonn-[auto: BMW ::: salary: 12345] в столбик. Т.е в файле нужна только эта инфа
         */
        ArrayList<Developer> listOfDevelopers = Generator.generateDevelopersAndCars(5);
        Processor processor = new Processor();
        processor.printListOfDevelopers(listOfDevelopers);
        processor.printMenWithSportcars(listOfDevelopers);

        System.out.println("Группировка машин по полу владельца:");
        System.out.println(processor.groupCarsByGender(listOfDevelopers));

        System.out.println("Соответствие владельца и максимальной скорости его машины:");
        System.out.println(processor.generateMapDeveloperSpeed(listOfDevelopers));

        processor.createFileWithInfo(listOfDevelopers);


    }


}
