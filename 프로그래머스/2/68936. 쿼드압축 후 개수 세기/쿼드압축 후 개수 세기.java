public class Solution {

    static class Compression {

        int one;
        int zero;

        public Compression(int one, int zero) {
            this.one = one;
            this.zero = zero;
        }

        public Compression sum(Compression other) {
            return new Compression(this.one + other.one, this.zero + other.zero);
        }

        @Override
        public String toString() {
            return "Compression{" +
                "one=" + one +
                ", zero=" + zero +
                '}';
        }
    }

    public static Compression compress(int x, int y, int length, int[][] arr) {

        if (length == 1) {
            if (arr[y][x] == 1) {
                return new Compression(1, 0);
            } else {
                return new Compression(0, 1);
            }
        }

        if (!isSame(x, y, length, arr)) {
            return compress(x, y, length / 2, arr)
                .sum(compress(x + length / 2, y, length / 2, arr))
                .sum(compress(x, y + length / 2, length / 2, arr))
                .sum(compress(x + length / 2, y + length / 2, length / 2, arr));
        }

        return arr[y][x] == 1 ? new Compression(1, 0) : new Compression(0, 1);
    }


    public static int[] solution(int[][] arr) {
        Compression compress = compress(0, 0, arr.length, arr);
        return new int[]{compress.zero, compress.one};
    }

    public static boolean isSame(int x, int y, int length, int[][] arr) {
        int start = arr[y][x];

        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (start != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
