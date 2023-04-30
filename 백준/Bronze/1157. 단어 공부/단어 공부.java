import java.util.*;

public class Main {

    public static int[] alphabet = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            alphabet[str.charAt(i) - 'a'] += 1;
        }

        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        boolean flag = false;
        for (int i = 0; i < alphabet.length; i++) {
            if (maxValue <= alphabet[i]) {
                maxValue = alphabet[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (maxIndex != i && maxValue == alphabet[i]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("?");
        } else {
            System.out.println((char) (maxIndex + 'A'));
        }
    }
}
