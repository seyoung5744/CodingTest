import java.util.*;

public class Main {

    public static int[] dice = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int num = sc.nextInt();
            dice[num] += 1;
        }

        int result = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < dice.length; i++) {
            if(dice[i] == 3){
                result = 10000 + (i * 1000);
                break;
            }else if(dice[i] == 2){
                result = 1000 + (i * 100);
                break;
            }else if(dice[i] == 1){
                max = Math.max(max, i);
                result = max * 100;
            }
        }

        System.out.println(result);

    }
}
