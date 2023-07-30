public class Developer {
    // Написать класс Девелопер у которого будет имя, фамилия , возраст, зарплата, чар- пол и машина
    private String firstname;
    private String lastname;
    private int age;
    private double salary;
    private char gender;
    private Car car;

    public Developer(String firstname, String lastname, int age, double salary, char gender, Car car) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", car=" + car +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public char getGender() {
        return gender;
    }

    public Car getCar() {
        return car;
    }
}
