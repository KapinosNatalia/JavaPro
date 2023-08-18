package Task1;

import java.util.List;

public class OddEvenLists {
    private final List<Integer> oddList;
    private final List<Integer> evenList;

    public OddEvenLists(List<Integer> oddList, List<Integer> evenList) {
        this.oddList = oddList;
        this.evenList = evenList;
    }

    public List<Integer> getOddList() {
        return oddList;
    }

    public List<Integer> getEvenList() {
        return evenList;
    }


}
