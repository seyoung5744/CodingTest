class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] map = new char[park.length][park[0].length()];
        int x = -1, y = -1;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = j;
                    y = i;
                }
                map[i][j] = park[i].charAt(j);
            }
        }

        for (String route : routes) {
            String[] tokens = route.split(" ");
            String direction = tokens[0];
            int length = Integer.parseInt(tokens[1]);

            int nx = x;
            int ny = y;
            boolean flag = true;
            for (int i = 0; i < length; i++) {
                switch (direction) {
                    case "N":
                        ny -= 1;
                        break;
                    case "S":
                        ny += 1;
                        break;
                    case "W":
                        nx -= 1;
                        break;
                    case "E":
                        nx += 1;
                        break;
                }

                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length || map[ny][nx] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                x = nx;
                y = ny;
            }
        }


        return new int[]{y, x};
    }
}