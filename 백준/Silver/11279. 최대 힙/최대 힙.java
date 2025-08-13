import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] array;
    private static int lastIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            insert(num);
            if(num == 0) {
                System.out.println(delete());
            }
        }
        br.close();
    }

    public static void insert(int num) {
        array[++lastIndex] = num;

        int curData = array[lastIndex];
        int curIdx = lastIndex;

        while (curIdx > 1 && array[curIdx] > array[curIdx / 2]) {
            int parentVal = array[curIdx / 2];

            array[curIdx / 2] = curData;
            array[curIdx] = parentVal;
            curIdx /= 2;
        }
    }

    public static int delete() {
        if (array.length == 1) {
            System.out.println(0);
            return -1;
        }

        int target = array[1];
        array[1] = array[array.length - 1];
        array[array.length - 1] = 0;

        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < array.length) {
                targetIdx = array[leftIdx] > array[rightIdx] ? leftIdx : rightIdx;
            } else if (leftIdx < array.length) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (array[cur] > array[targetIdx]) {
                break;
            } else {
                int parentVal = array[cur];

                array[cur] = array[targetIdx];
                array[targetIdx] = parentVal;
                cur = targetIdx;
            }
        }
        return target;
    }


}
