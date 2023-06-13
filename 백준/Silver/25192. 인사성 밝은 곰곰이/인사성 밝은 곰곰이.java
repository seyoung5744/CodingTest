import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        Set<String> personSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();

            if (cmd.equals("ENTER")) {
                cnt += personSet.size();
                personSet.clear();
            } else {
                personSet.add(cmd);
            }
        }
        cnt += personSet.size();
        System.out.println(cnt);
    }

}
