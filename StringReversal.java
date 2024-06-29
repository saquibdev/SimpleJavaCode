import java.util.Scanner;
import java.lang.StringBuilder;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to be reversed : Only work till first whitespace will be considered");
        String inputStr = sc.next(); //This will take input only till first whitespace character
        //Using StringBuilder
        StringBuilder sb = new StringBuilder(inputStr);
        System.out.println(sb.reverse());//Here toString() is not used as println also prints StringBuilder directly

        sc.nextLine(); //This is to consume remaining part of first input string
        System.out.println("Enter the String to be reversed : General String");
        inputStr = sc.nextLine();
        sb = new StringBuilder(inputStr);
        System.out.println(sb.reverse());
    }
}
