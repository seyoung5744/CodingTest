#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int solution(int x, int y, int n) {
    vector<int> dp(y + 1, 1000001);
    dp[x] = 0;

    for (int i = x + 1; i <= y; i++) {
        // n을 더하는 경우
        if (i - n >= x) {
            dp[i] = min(dp[i], dp[i - n] + 1);
        }

        // 2를 곱하는 경우
        if (i % 2 == 0) {
            dp[i] = min(dp[i], dp[i / 2] + 1);
        }

        // 3을 곱하는 경우
        if (i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1);
        }
    }

    return (dp[y] == 1000001) ? -1 : dp[y];
}