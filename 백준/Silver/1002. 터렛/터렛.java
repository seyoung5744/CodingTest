import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x2 - x1;
            int dy = y2 - y1;
            int distanceSq = dx * dx + dy * dy;
            int sumR = r1 + r2;
            int diffR = Math.abs(r2 - r1);

            if (x1 == x2 && y1 == y2 && r1 == r2) { // 무한대
                System.out.println(-1);
            } else if (distanceSq == sumR * sumR || distanceSq == diffR * diffR) { // 외접 또는 내접
                System.out.println(1);
            } else if (diffR * diffR < distanceSq && distanceSq < sumR * sumR) {// 두 점이 만남
                System.out.println(2);
            } else { // 만나지 않음
                System.out.println(0);
            }
        }

        br.close();
    }
}
