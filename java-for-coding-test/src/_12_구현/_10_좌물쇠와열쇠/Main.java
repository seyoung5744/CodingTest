package _12_구현._10_좌물쇠와열쇠;

public class Main {

    public static boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;

        int[][] newLock = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        int m = key.length;

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key);
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x+i][y+j] += key[i][j];
                        }
                    }

                    if(check(newLock)){
                        return true;
                    }

                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean check(int[][] arr) {
        int n = arr.length / 3;

        for (int i = n; i < n*2; i++) {
            for (int j = n; j < n*2; j++) {
                if (arr[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // 결과 리스트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

}
