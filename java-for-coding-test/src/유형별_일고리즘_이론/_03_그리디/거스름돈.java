package 유형별_일고리즘_이론._03_그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 1260;
        int count = 0;

        int[] list = {500, 100, 50, 10};

        for(int coin : list){
            count += n / coin;
            n %= coin;
        }

        System.out.println(count);
    }
}
