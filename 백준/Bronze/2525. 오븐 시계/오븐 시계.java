import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int time = sc.nextInt();

        int sum = minute + time;
        if(sum >= 60){
            hour+= (sum / 60);
            sum %= 60;
        }
        if(hour >= 24){
            hour %= 24;
        }

        System.out.println(hour + " " + sum);
    }

}
