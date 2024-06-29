import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConversion {
    public static void main(String[] args) {
        String originalFormat = "yyyy-MM-dd";
        String newFormat = "dd/MM/yyyy";

        String originalDate = "2023-12-21";
        DateTimeFormatter originalFormatter = DateTimeFormatter.ofPattern(originalFormat);

        LocalDate date = LocalDate.parse(originalDate,originalFormatter);

        //Now we need formatter for new format
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern(newFormat);
        String newDateString = date.format(newFormatter);

        System.out.println("newDateString: " + newDateString);

    }
}
