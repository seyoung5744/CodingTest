#include <vector>

using namespace std;

int MOD = 20170805;

int GetLeftCase(int startI, int startJ, vector<vector<int>>& map, vector<vector<int>>& dp)
{
    for(int j = startJ; j >= 0; --j)
    {
        if (map[startI][j] == 2)
            continue;
        
        return dp[startI][j];
    }
    
    return 0;
}

int GetTopCase(int startI, int startJ, vector<vector<int>>& map, vector<vector<int>>& dp)
{
    for(int i = startI; i >= 0; --i)
    {
        if (map[i][startJ] == 2)
            continue;
        
        return dp[i][startJ];
    }
    
    return 0;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int m, int n, vector<vector<int>> city_map) {
    int answer = 0;
    
    vector<vector<int>> dp (m, vector<int> (n, 0));
    dp[0][0] = 1;
    
    for(int i = 0; i < m; ++i)
    {
        for(int j = 0; j < n; ++j)
        {
            if (i == 0 && j == 0)
                continue;
            
            if (city_map[i][j] == 1)
            {
                dp[i][j] = 0;
                continue;
            }
            
            dp[i][j] = (GetLeftCase(i, j - 1, city_map, dp) + GetTopCase(i - 1, j, city_map, dp)) % MOD;
        }
    }
    
    answer = dp.back().back() % MOD;
    return answer;
}