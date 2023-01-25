import java.io.*;

public class Main {

    static int[] array;
    static int lastIndex = 0;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        array = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            insert(data);
            if(data == 0){
                System.out.println(delete());
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean insert(int data) {
        array[++lastIndex] = data;

        int curData = array[lastIndex];
        int cur = lastIndex;

        while (cur > 1 && array[cur] > array[cur / 2]) {
            int parentVal = array[cur / 2];

            array[cur / 2] = curData;
            array[cur] = parentVal;
            cur /= 2;
        }

        size++;
        return true;
    }

    public static Integer delete() {
        if (array.length == 1) {
            System.out.println(0);
            return null;
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

            if(array[cur] > array[targetIdx]){
                break;
            }else{
                int parentVal = array[cur];
                array[cur] = array[targetIdx];
                array[targetIdx] = parentVal;
                cur = targetIdx;
            }
        }
        return target;
    }
}
