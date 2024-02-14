import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static class Point {

        boolean isPillar;
        boolean isBo;

    }

    private static Point[][] map;

    public static int[][] solution(int n, int[][] build_frame) {
        List<int[]> answer = new ArrayList<>();

        map = new Point[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                map[i][j] = new Point();
            }
        }

        for (int[] frame : build_frame) {
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            boolean isPillar = frame[2] == 0;
            boolean isInstall = frame[3] == 1;

            if (isInstall) { // 설치
                if (isPillar) { // 기둥
                    if (canInstallPillar(x, y)) {
                        map[y][x].isPillar = true;
                    }
                } else { // 보
                    if (canInstallBo(x, y)) {
                        map[y][x].isBo = true;
                    }
                }
            } else { // 삭제
                if (isPillar) {
                    map[y][x].isPillar = false;

                    if (map[y + 1][x].isPillar) {
                        if (!canInstallPillar(x, y + 1)) {
                            map[y][x].isPillar = true;
                            continue;
                        }
                    }

                    if (map[y + 1][x].isBo) {
                        if (!canInstallBo(x, y + 1)) {
                            map[y][x].isPillar = true;
                            continue;
                        }
                    }

                    if (map[y + 1][x - 1].isBo) {
                        if (!canInstallBo(x - 1, y + 1)) {
                            map[y][x].isPillar = true;
                            continue;
                        }
                    }
                } else { // 보 삭제
                    map[y][x].isBo = false;

                    if (map[y][x - 1].isBo) {
                        if (!canInstallBo(x - 1, y)) {
                            map[y][x].isBo = true;
                            continue;
                        }
                    }

                    if (map[y][x + 1].isBo) {
                        if (!canInstallBo(x + 1, y)) {
                            map[y][x].isBo = true;
                            continue;
                        }
                    }

                    if (map[y][x].isPillar) {
                        if (!canInstallPillar(x, y)) {
                            map[y][x].isBo = true;
                            continue;
                        }
                    }
                    if (map[y][x + 1].isPillar) {
                        if (!canInstallPillar(x + 1, y)) {
                            map[y][x].isBo = true;
                            continue;
                        }
                    }
                }
            }
        }

        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {

                if (map[j][i].isPillar) {
                    answer.add(new int[]{i - 1, j - 1, 0});
                }

                if (map[j][i].isBo) {
                    answer.add(new int[]{i - 1, j - 1, 1});
                }
            }
        }

        return answer.stream().toArray(int[][]::new);

    }

    public static boolean canInstallPillar(int x, int y) {
        if (y == 1) {
            return true;
        }

        if (map[y - 1][x].isPillar) { // 기둥 위 기둥
            return true;
        }

        if (map[y][x].isBo || map[y][x - 1].isBo) {
            return true;
        }

        return false;
    }

    public static boolean canInstallBo(int x, int y) {

        if (y <= 1) {
            return false;
        }

        if (map[y - 1][x].isPillar) {
            return true;
        }

        if (map[y - 1][x + 1].isPillar) {
            return true;
        }

        if (map[y][x - 1].isBo && map[y][x + 1].isBo) {
            return true;
        }
        return false;
    }


}
