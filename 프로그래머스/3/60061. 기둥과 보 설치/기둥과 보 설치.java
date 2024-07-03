import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    static class Point {

        boolean isBo;
        boolean isGi;
    }

    public static int[][] solution(int n, int[][] build_frame) {
        Point[][] map = new Point[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                map[i][j] = new Point();
            }
        }

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int kinds = frame[2]; // 0 : 기둥, 1 : 보
            int isInstall = frame[3]; // 0 : 삭제, 1 : 설치

            if (isInstall == 1) { // 설치
                if (kinds == 0) { // 기둥
                    if (x < 0 || x > n || y < 0 || y > n) {
                        continue;
                    }
                    if (canInstallGi(map, x, y)) {
                        map[y][x].isGi = true;

                    }

                } else { // 보
                    if (x < 0 || x > n || y < 0 || y > n) {
                        continue;
                    }

                    if (canInstallBo(map, x, y, n)) {
                        map[y][x].isBo = true;
                    }

                }
            } else { // 삭제
                if (kinds == 0) { // 기둥
                    map[y][x].isGi = false;

                    if (y + 1 < n && map[y + 1][x].isGi) {
                        if (!canInstallGi(map, x, y + 1)) {
                            map[y][x].isGi = true;
                            continue;
                        }
                    }

                    if (y + 1 < n && map[y + 1][x].isBo) {
                        if (!canInstallBo(map, x, y + 1, n)) {
                            map[y][x].isGi = true;
                            continue;
                        }
                    }

                    if (y + 1 <= n && x - 1 >= 0 && map[y + 1][x - 1].isBo) {
                        if (!canInstallBo(map, x - 1, y + 1, n)) {
                            map[y][x].isGi = true;
                            continue;
                        }
                    }
                } else { // 보
                    map[y][x].isBo = false;

                    if (x - 1 >= 0 && map[y][x - 1].isBo) {
                        if (!canInstallBo(map, x - 1, y, n)) {
                            map[y][x].isBo = true;
                            continue;
                        }

                    }

                    if (x + 1 <= n && map[y][x + 1].isBo) {
                        if (!canInstallBo(map, x + 1, y, n)) {
                            map[y][x].isBo = true;
                            continue;
                        }
                    }

                    if (map[y][x].isGi) {
                        if (!canInstallGi(map, x, y)) {
                            map[y][x].isBo = true;
                            continue;
                        }
                    }

                    if (x + 1 <= n && map[y][x + 1].isGi) {
                        if (!canInstallGi(map, x + 1, y)) {
                            map[y][x].isBo = true;
                            continue;
                        }
                    }
                }
            }
        }

        return print(map);
    }

    public static boolean canInstallGi(Point[][] map, int x, int y) {
        if (x - 1 >= 0) {
            if (map[y][x - 1].isBo) {
                return true;
            }
        }

        if (y == 0 || map[y - 1][x].isGi || map[y][x].isBo) {
            return true;
        }
        return false;
    }

    public static boolean canInstallBo(Point[][] map, int x, int y, int n) {
        if (y - 1 >= 0) {
            if (map[y - 1][x].isGi) {
                return true;
            } else if (x + 1 <= n && map[y - 1][x + 1].isGi) {
                return true;
            } else if (x - 1 >= 0 && x + 1 < n && map[y][x - 1].isBo && map[y][x + 1].isBo) {
                return true;
            }
        }
        return false;
    }

    public static int[][] print(Point[][] map) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j].isBo) {
                    result.add(new int[]{j, i, 1});
                }
                if (map[i][j].isGi) {
                    result.add(new int[]{j, i, 0});
                }
            }
        }

        return result.stream()
            .sorted(Comparator.comparing((int[] arr) -> arr[0])
                .thenComparing(arr -> arr[1])
                .thenComparing(arr -> arr[2]))
            .toArray(int[][]::new);
    }

}