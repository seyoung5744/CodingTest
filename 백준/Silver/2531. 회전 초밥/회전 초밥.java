import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 개수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가지 수
        int k = Integer.parseInt(st.nextToken()); // 연속 가능 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];
        int[] eated = new int[d + 1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (eated[sushi[i]] == 0) {
                count++;
            }

            eated[sushi[i]]++;
        }


        int maxLen = count;

        for (int i = 1; i < N; i++) {

            if (maxLen <= count) {
                if (eated[c] == 0) {
                    maxLen = count + 1;
                } else {
                    maxLen = count;
                }
            }

            int end = (i + k - 1) % N;

            if(eated[sushi[end]] == 0) {
                count++;
            }
            eated[sushi[end]]++;

            // start 이동
            eated[sushi[i - 1]]--;	// start점 한 칸 이동했으니 이전의 초밥 제거
            if(eated[sushi[i - 1]] == 0) {
                count--;
            }
        }

        System.out.println(maxLen);

        bw.flush();
        br.close();
        bw.close();
    }

}
