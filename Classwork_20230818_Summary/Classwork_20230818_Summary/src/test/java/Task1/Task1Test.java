package Task1;

import Task1.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Task1Test {
    @Test
    void getEvenOddNumbersTest() {
        List<Integer> list = List.of(1, 2, 3, 5, 8, 9);
        OddEvenLists oddEvenLists = Task1.getEvenOddNumbers(list);
        Assertions.assertEquals(Arrays.asList(2,  8), oddEvenLists.getEvenList());
        Assertions.assertEquals(Arrays.asList(1, 3, 5, 9),oddEvenLists.getOddList());
    }
    @Test
    void getEvenOddNumbersExceptionTest() {
        List<Integer> list = List.of();
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task1.getEvenOddNumbers(list));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task1.getEvenOddNumbers(null));
    }

}