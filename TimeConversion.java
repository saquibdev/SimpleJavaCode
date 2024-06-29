import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
    public static void main(String[] args) {
        String inputDateStr = "2023-12-24 11:01:00";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the input string into a LocalDateTime object
        LocalDateTime parsedDateTime = LocalDateTime.parse(inputDateStr, inputFormatter);

        // Define the desired output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

        // Format the LocalDateTime object using the output formatter
        String formattedDateStr = parsedDateTime.format(outputFormatter);

        // Print the converted date string
        System.out.println("Converted date string: " + formattedDateStr);
    }
}
