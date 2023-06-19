import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * Класс Person  name (имя) и age (возраст) *
     */
    public static void main(String[] args) {

//        * 1. Создать и заполнить две мапы.
//        * Затем перебрать обе мапы и вывести на экран
//        * информацию о каждом человеке (из Map<String, Person>)
//        * в формате: "Имя: <name>, Возраст: <age>".
//        * Для каждого элемента Map<String, String> добавить
//        * к значению строку "is a person".
//        *
        System.out.println("task 1");
        Map<String, Person> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map1.put("Person1", new Person("Ivan", 25));
        map1.put("Person2", new Person("Evgeniy", 35));
        map1.put("Person3", new Person("Petr", 45));
        for (Map.Entry<String, Person> entry: map1.entrySet() ) {
            System.out.println("Имя: " + entry.getValue().getName() + ", возраст: " + entry.getValue().getAge());
            map2.put(entry.getValue().getName(), Integer.toString(entry.getValue().getAge()));
        }
        for (Map.Entry<String, String> entry: map2.entrySet() ) {
           map2.put(entry.getKey(),entry.getValue() + " is a person");
            System.out.println("Имя: " + entry.getKey() + ", возраст: " + entry.getValue());
        }

//        * 2. Создать и заполнить две мапы.
//                * Затем перебрать обе мапы и вывести на экран
//                * только имена людей (из Map<String, Person>).
//     *
        System.out.println("task 2");
        for (Map.Entry<String, Person> entry: map1.entrySet()) {
            System.out.println("Имя: " + entry.getValue().getName());
        }

//        * 3. Создать и заполнить две мапы.
//                * Затем перебрать обе мапы и вывести на экран
//                * средний возраст всех людей (из Map<String, Person>).
//                *
        int sum = 0;
        for (Map.Entry<String, Person> entry: map1.entrySet()) {
            sum += entry.getValue().getAge();
        }
        System.out.println(sum/map1.size());

//        * 4. Создать и заполнить две мапы.
//                * Затем перебрать обе мапы и создать новый мап
//                * (Map<String, String>), где ключом будет имя человека,
//     * а значением будет его возраст в виде строки.

        Map<String, Person> personMap = new HashMap<>();
        personMap.put("1", new Person("Anna", 23));
        personMap.put("2", new Person("Maria", 33));

        Map<String, String> map_task4 = new HashMap<>();
        for (Map.Entry<String,Person> entry: map1.entrySet()) {
            map_task4.put(entry.getValue().getName(), Integer.toString(entry.getValue().getAge()));
        }



    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
