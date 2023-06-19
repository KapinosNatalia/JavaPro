import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTasks {
    public static void main(String[] args) {

         // 13. Создать список List, заполнить его несколькими значениями и вывести на экран каждый элемент списка.
        List<Integer> listTask13 = new LinkedList<>();
        listTask13.add(5);
        listTask13.add(4);
        listTask13.add(3);
        listTask13.add(2);
        listTask13.add(1);
        System.out.print("Task 13: ");
        for (Integer listElem:listTask13) {
            System.out.print(listElem + " ");
        }
        System.out.println();

         // 14. Создать список List, заполнить его несколькими значениями и вывести на экран каждый элемент списка.
         // через итератор делаю для тренировки себя
        List<Integer> listTask14 = new LinkedList<>();
        listTask14 = List.of(new Integer[]{15, 14, 13, 12, 11});
        ListIterator<Integer> listIteratorTask14 = listTask14.listIterator();
        System.out.print("Task 14: ");
        while (listIteratorTask14.hasNext()) {
            System.out.print(listIteratorTask14.next() + " ");
        }
        System.out.println();

         // 15. Создать список List, заполнить его несколькими значениями. Затем перебрать список и вывести элементы в обратном порядке.
        List<Integer> listTask15 = new LinkedList<>();
        listTask15 = List.of(new Integer[]{25, 24, 23, 22, 21});
        ListIterator<Integer> listIteratorTask15 = listTask15.listIterator(listTask15.size());
        System.out.print("Task 15: ");
        while (listIteratorTask15.hasPrevious()) {
            System.out.print(listIteratorTask15.previous() + " ");
        }
        System.out.println();
    }
}
