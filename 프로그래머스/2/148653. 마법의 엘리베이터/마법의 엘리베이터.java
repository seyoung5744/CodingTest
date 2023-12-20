class Solution {
    public int solution(int storey) {
        return sol(storey);
    }
    
    public int sol(int storey) {
        if(storey < 10) return Math.min(storey, 10 - storey + 1);
        int down = storey % 10;
        int up = 10 - storey % 10;
        
        return Math.min(sol((storey - down) / 10) + down , sol( (storey + up) / 10) + up);
    }
}