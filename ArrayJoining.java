import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayJoining {
    public static void main(String[] args) {
        String array[] = new String[4];
        array[0] = "Sachin";
        array[1] = "Hayden";
        array[2] = "Ricky";
        array[3] = "Wasim";

        String joinedString = Arrays.stream(array).collect(Collectors.joining(","));
        System.out.println(joinedString);

        List<Integer> lst = new ArrayList<Integer>();
        lst.add(6);lst.add(1);lst.add(5);lst.add(2);

        Integer i = lst.stream().max(Comparator.comparingInt(a -> a)).get();
        System.out.println(i);


    }
}
