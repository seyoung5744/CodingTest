import java.util.*;

public class Main {

    public static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String[] months = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += days[i];
        }

        sum += day;
        System.out.println(months[sum % 7]);
    }
}
