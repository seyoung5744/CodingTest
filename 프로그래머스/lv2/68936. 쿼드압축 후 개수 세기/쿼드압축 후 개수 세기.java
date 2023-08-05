class Solution {

    private static class Count {

        private final int zero;
        private final int one;

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

    private static Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                        .add(count(offsetX, offsetY + h , h, arr))
                        .add(count(offsetX + h, offsetY, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

}
