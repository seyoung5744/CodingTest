import java.util.Scanner;

public class Main {
    public static final String l = "long";
    public static final String i = "int";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n/4; j++) {
            sb.append(l).append(" ");
        }
        sb.append(i);

        System.out.println(sb);
    }

}
