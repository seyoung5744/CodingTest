public class Solution {

    public static long solution(int w, int h) {
        int gcb = gcb(w, h); // 최대 공약수

        int ww = w / gcb;
        int hh = h / gcb;

        int count = (ww * hh) - (ww - 1) * (hh - 1);

        return ((long) w * h) - (count * gcb);
    }

    public static int gcb(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
