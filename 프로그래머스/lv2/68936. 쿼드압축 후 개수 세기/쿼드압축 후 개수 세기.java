class Solution {
    private static class Count {

        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(this.zero + other.zero, this.one + other.one);
        }
    }

    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int i = offsetX; i < offsetX + size; i++) {
            for (int j = offsetY; j < offsetY + size; j++) {
                if (arr[j][i] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                        .add(count(offsetX + h, offsetY, h, arr))
                        .add(count(offsetX, offsetY + h, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        // 모든 원소가 같은 값인 경우
        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }
}