import java.util.Random;

public class NameGenerator {
    private static final String[] menFirstNames = {"Иван", "Олег", "Алексей", "Степан", "Илья", "Глеб", "Петр"};
    private static final String[] menSecondNames = {"Иванович", "Олегович", "Алексеевич", "Степанович", "Ильич", "Глебович", "Петрович"};
    private static final String[] menSurnames = {"Иванов", "Олегов", "Алексеев", "Степанов", "Ильин", "Глебов", "Петров"};
    private static final String[] womenFirstNames = {"Ирина", "Ольга", "Алиса", "Светлана", "Ирида", "Галина", "Полина"};
    private static final String[] womenSecondNames = {"Ивановна", "Олеговна", "Алексеевна", "Степановна", "Ильинична", "Глебовна", "Петровна"};
    private static final String[] womenSurnames = {"Иванова", "Олегова", "Алексеева", "Степанова", "Ильина", "Глебова", "Петрова"};

    public static String generateMenName() {
        Random random = new Random();
        return menFirstNames[random.nextInt(0, 7)] + " " +
                menSecondNames[random.nextInt(0, 7)] + " " +
                menSurnames[random.nextInt(0, 7)];
    }

    public static String generateWomanName() {
        Random random = new Random();
        return womenFirstNames[random.nextInt(0, 7)] + " " +
                womenSecondNames[random.nextInt(0, 7)] + " " +
                womenSurnames[random.nextInt(0, 7)];
    }
}
