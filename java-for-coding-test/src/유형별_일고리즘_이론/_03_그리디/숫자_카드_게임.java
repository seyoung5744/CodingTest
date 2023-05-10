package 유형별_일고리즘_이론._03_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_카드_게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cards = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
//                if(minValue > cards[i][j]){
//                    minValue = cards[i][j];
//                }
                minValue = Math.min(minValue, cards[i][j]);
            }

//            if(answer < minValue){
//                answer = minValue;
//            }
            answer = Math.max(answer, minValue);
        }

        System.out.println(answer);
    }

}
