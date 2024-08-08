#include <string>
#include <vector>
#include <cmath>
using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    vector<vector<int>> dp = triangle;
    
    for(int i = 1; i < dp.size(); ++i) {
        for(int j = 0; j <= i; ++j) {
            int left = j - 1;
            int right = j;
            
            if (left < 0) {
                dp[i][j] += dp[i-1][right];
            } else if (right > i-1) {
                dp[i][j] += dp[i-1][left];
            } else {
                dp[i][j] += max(dp[i-1][right], dp[i-1][left]);
            }
        }
    }
    for(int i = 0; i < dp.back().size(); ++i) {
        answer = max(answer, dp.back()[i]);
    }
    return answer;
}