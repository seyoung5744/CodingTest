#include <string>
#include <vector>
#include <set>
#include <iostream>
#include <cmath>
using namespace std;

set<int> nums;

void recursive(string num, string& numbers, vector<bool> visited)
{
    nums.insert(stoi(num));
    
    for(int i = 0; i < numbers.length(); ++i)
    {
        if (visited[i] == true)
            continue;
        
        visited[i] = true;
        recursive(num + numbers[i], numbers, visited);
        visited[i] = false;
    }
}

int solution(string numbers) {
    int answer = 0;
    
    recursive("0", numbers, vector<bool> (numbers.size(), false));
    
    for(auto n : nums)
    {
        bool flag = true;
        if (n <= 1)
            continue;
        if (n == 2)
        {
            ++answer;
            continue;
        }
        
        for(int i = 2; i <= sqrt(n) && flag; ++i)
        {
            if (n % i == 0)
            {
                flag = false;
            }
        }
        
        if (flag)
        {
            ++answer;
        }
    }
    
    return answer;
}