import java.util.Objects;

//        Person:
//        Поля:
//        String name
//        int age
//        String address
//        String email
//        Методы:
//
//        Конструктор с параметрами для инициализации полей.
//        String getSummary() - возвращает строку, содержащую информацию о человеке (имя, возраст, адрес).
//        boolean isAdult() - проверяет, является ли человек совершеннолетним (возраст >= 18).
//        void sendEmail(String message) - имитирует отправку электронной почты.
public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String address;
    private String email;

    private final int AGE_ADULT = 18;

    public Person(String name, int age, String address, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    @Override
    public int compareTo(Person o) {
        int name = this.name.compareTo(o.getName());
        if (name == 0) {
            return this.age - o.age;
        }
        return name;
    }

    // возвращает строку, содержащую информацию о человеке (имя, возраст, адрес)
    public String getSummary() {
        return String.format("%s (%d) - [%s]", this.name, this.age, this.address);
    }

    // - проверяет, является ли человек совершеннолетним (возраст >= 18).
    public boolean isAdult() {
        return age >= AGE_ADULT;
    }

    //  имитирует отправку электронной почты.
    public void sendEmail(String message) {
        System.out.println("Email was sent by " + email);
    }
}
