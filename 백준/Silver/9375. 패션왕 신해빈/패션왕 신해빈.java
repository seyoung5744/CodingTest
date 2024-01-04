import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split(" ");
                map.put(tokens[1], map.getOrDefault(tokens[1], 0) + 1);
            }

            int result = 1;
            for(int val : map.values()) {
                result *= (val + 1);
            }

            System.out.println(result - 1);
        }
    }

}
