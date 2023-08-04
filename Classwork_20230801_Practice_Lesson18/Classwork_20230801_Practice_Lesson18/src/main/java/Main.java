import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /*
    Сделать проверку на валидность имени
    Сделать проверку на валидность пароля
    */
    static Scanner scanner = new Scanner(System.in);
    static String regex = "\\d{3}"; // шаблон для цифр

    public static void main(String[] args) {
        regex = "\\w{3}"; // шаблон для буквы/цифры/нижнего подчеркивания латинницей
        //regex = "\\p{3}"; // шаблон для буквы/цифры/нижнего подчеркивания латинницей и кириллицей

        regex = "\\w{3}\\S"; // три символа и 4 символ не пробел
        regex = "[A-Z][a-z]*"; // первая буква большая, остальные маленькие
        regex = "([A-Z][a-z]*\\s?)*";
        regex = "([A-Z][a-z]*(\\s{1}[A-Z][a-z]*)|$)*";
        regex = "([A-Z][a-z]*)((\\s{1}[A-Z][a-z]*)|$)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        System.out.println("Введите имя");
        String str = scanner.nextLine();
        matcher = pattern.matcher(str);
        System.out.println(matcher.matches());

    }


}
