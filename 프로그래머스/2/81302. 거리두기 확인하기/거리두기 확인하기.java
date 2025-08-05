class Solution {
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1}; // 상, 좌, 우, 하

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            char[][] room = new char[5][5];
            for (int j = 0; j < places[i].length; j++) {
                room[j] = places[i][j].toCharArray();
            }

            if (isDistanced(room)) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    private boolean isDistanced(char[][] room) {

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                if (room[i][j] != 'P') continue;

                if (!isDistanced(room, j, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isDistanced(char[][] room, int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= room[0].length || ny < 0 || ny >= room.length) continue;

            if (room[ny][nx] == 'P') return false;
            if (room[ny][nx] == 'O') {
                if (isNextToVolunteer(room, nx, ny, 3 - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {

        for (int i = 0; i < 4; i++) {
            if (i == exclude) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= room[0].length || ny < 0 || ny >= room.length) continue;

            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
}