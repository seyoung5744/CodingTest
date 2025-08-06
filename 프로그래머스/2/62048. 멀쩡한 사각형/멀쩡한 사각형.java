class Solution {
    public long solution(int w, int h) {
        int gcb = gcb(w, h);
        int ww = w / gcb;
        int hh = h / gcb;

        return (long) w * h - ((long) (ww + hh - 1) * gcb);
    }

    private int gcb(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}