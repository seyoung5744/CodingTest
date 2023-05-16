import java.util.*;
import java.io.*;

public class Main {

    public static int[] x = new int[4];
    public static int[] y = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
            int y = Integer.parseInt(st.nextToken());
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        int answerX = 0;
        for(Map.Entry<Integer, Integer> entry : xMap.entrySet()){
            if(entry.getValue() == 1){
                answerX = entry.getKey();
            }
        }

        int answerY = 0;
        for(Map.Entry<Integer, Integer> entry : yMap.entrySet()){
            if(entry.getValue() == 1){
                answerY = entry.getKey();
            }
        }

        System.out.println(answerX + " " + answerY);
    }
}
