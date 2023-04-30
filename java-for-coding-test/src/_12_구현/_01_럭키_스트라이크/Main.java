package _12_구현._01_럭키_스트라이크;

import java.util.*;

public class Main {

    public static int summary;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strNum = sc.next();

        int length = strNum.length();

        for (int i = 0; i < length / 2; i++) {
            summary += (strNum.charAt(i) - '0');
        }
        for (int i = length / 2; i < length; i++) {
            summary -= (strNum.charAt(i) - '0');
        }

        if(summary == 0){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }
    }
}
