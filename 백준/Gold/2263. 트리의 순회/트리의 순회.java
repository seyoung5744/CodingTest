import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] in, post;
    public static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        post = new int[n];
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        
        getPreOrder(0, n-1, 0, n-1);
    }

    public static void getPreOrder(int is, int ie, int ps, int pe) {
        // is는 인오더 범위의 시작 위치, ie는 인오더의 끝 위치
        // ps는 포스트오더 범위의 시작 위치, pe는 끝위치

        if (is <= ie && ps <= pe) {
            System.out.print(post[pe] + " ");

            int inRoot = is;

            for (int i = is; i <= ie; i++) {
                if (in[i] == post[pe]) {
                    inRoot = i;
                    break;
                }
            }

            getPreOrder(is, inRoot - 1, ps, ps + inRoot - is - 1);
            getPreOrder(inRoot + 1, ie, ps + inRoot - is, pe - 1);
        }
    }
}
