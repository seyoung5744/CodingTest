import java.util.Arrays;

public class Solution {

    public static int[] dx = {0, 1, -1, 0}; // 하, 우, 좌, 상
    public static int[] dy = {1, 0, 0, -1};

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            if(validation(places[i])) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    public static boolean validation(String[] place) {
        for (int y = 0; y < place.length; y++) {
            for (int x = 0; x < place[y].length(); x++) {

                if (place[y].charAt(x) != 'P') {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;

                    if (nx < 0 || nx >= place.length || ny < 0 || ny >= place[y].length()) {
                        continue;
                    }

                    if(place[ny].charAt(nx) == 'P') {
                        return false;
                    }
                    
                    if (place[ny].charAt(nx) != 'O') {
                        continue;
                    }
                    
                    for (int j = 0; j < 4; j++) {
                        if (j != 3 - i) {
                            int nnx = dx[j] + nx;
                            int nny = dy[j] + ny;

                            if (nnx < 0 || nnx >= place.length || nny < 0 || nny >= place[y].length()) {
                                continue;
                            }

                            if (place[nny].charAt(nnx) == 'P') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
