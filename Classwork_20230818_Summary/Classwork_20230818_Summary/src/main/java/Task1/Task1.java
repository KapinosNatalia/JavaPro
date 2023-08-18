package Task1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {
    // Разделить четные и нечетные числа на два списка
    public static OddEvenLists getEvenOddNumbers(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty or NULL");
        }
        Map<Boolean, List<Integer>> map = list.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0));

        return new OddEvenLists(map.get(false), map.get(true));
    }
}
