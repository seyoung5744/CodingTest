class Solution {
    private static int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        search(k, dungeons, visited, 0);
        return max;
    }

    private static void search(int k, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                search(k - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }

        if(max < count){
            max = count;
        }
    }
}