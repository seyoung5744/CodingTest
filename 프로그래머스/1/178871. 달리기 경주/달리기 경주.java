import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            indices.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int cur = indices.get(callings[i]);
            
            String temp = players[cur];
            players[cur] = players[cur - 1];
            players[cur - 1] = temp;
            
            indices.put(players[cur], cur);
            indices.put(players[cur - 1], cur - 1);
        }
        return players;
    }
    
}