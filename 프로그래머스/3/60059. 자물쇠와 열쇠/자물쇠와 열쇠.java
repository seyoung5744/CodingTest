public class Solution {

    public static boolean solution(int[][] key, int[][] lock) {
        int[][] extendLock = new int[lock.length * 3][lock.length * 3];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                extendLock[i + lock.length][j + lock.length] = lock[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            key = rotate(key);
            if (makeArr(key, extendLock)) {
                return true;
            }
        }

        return false;
    }

    public static int[][] rotate(int[][] arr) {
        int[][] result = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[arr.length - 1 - j][i];
            }
        }

        return result;
    }

    public static boolean makeArr(int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length - key.length + 1; i++) {
            for (int j = 0; j < lock.length - key.length + 1; j++) {
                int[][] makeArr = makeArr(key, copy(lock), i, j);

                boolean result = validation(makeArr);

                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] makeArr(int[][] key, int[][] lock, int y, int x) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                lock[i + y][j + x] += key[i][j];
            }
        }
        return lock;
    }

    private static int[][] copy(int[][] arr) {
        int[][] result = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }

    private static boolean validation(int[][] arr) {
        for (int i = 0; i < arr.length / 3; i++) {
            for (int j = 0; j < arr.length / 3; j++) {
                if (arr[i + arr.length / 3][j + arr.length / 3] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
