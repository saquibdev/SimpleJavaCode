import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListJoining {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sachin");
        list.add("Adam");
        list.add("Hayden");
        list.add("Ali");

        String joinedString = list.stream().collect(Collectors.joining(","));
        System.out.println(joinedString);

    }
}
