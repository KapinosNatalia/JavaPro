package Task2;

public class Task2 {
    // Дизайн ООП
    // На вход дан CSV файл. Требуется написать модуль, который индексирует этот файл и предоставляет метод для поиска
    // индекса по значению
    // RowIndex find(fieldName: String, value: String)
    // , где RowIndex = Integer
    //

    // employee,department,salary
    // Ivanov,IT,2500
    // Sidorov,Administration,4000

    // [
    //  employee: [[Ivanov: 0], [Sidorov: 1]],
    //  department: [[IT: 0], [Administration: 1]]
    //  salary: [[2500: 0], [4000: 0]]
    //  ]

    public static void main(String[] args) {
        System.out.println(CSVDataReader.readCSVData("Task2.csv"));
    }
}
