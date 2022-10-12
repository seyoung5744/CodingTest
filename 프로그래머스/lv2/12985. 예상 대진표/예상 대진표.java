class Solution
{
    public int solution(int n, int a, int b)
    {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int round = 1;
        for (int j = 2; j <=n ; j*=2) {
            if(min % 2 != 0){
                min+=1;
            }
            if(max %2 != 0){
                max+=1;
            }

            min /= 2;
            max /= 2;
            round+=1;
            if(max==min){
                break;
            }
        }
        return round-1;
    }

}