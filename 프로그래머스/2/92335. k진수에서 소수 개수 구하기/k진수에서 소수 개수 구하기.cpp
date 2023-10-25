#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <cmath>
using namespace std;

string Transform(int n, int k)
{
    string answer = "";
    
    while(n > 0)
    {
        answer.insert(answer.begin(), (n % k) + '0');
        n /= k;
    }
    
    return answer;
}

vector<string> Split(string input, char d)
{
    vector<string> answer;
    
    stringstream ss (input);
    string temp;
    
    while(getline(ss, temp, d))
    {
        if (temp == "")
            continue;
        answer.push_back(temp);
    }
    
    return answer;
}

bool IsPrime(long num)
{
    if (num < 2)
        return false;
    
    for(int i = 2; i <= sqrt(num); ++i)
    {
        if (num % i == 0)
            return false;
    }
    
    return true;
}

int solution(int n, int k) {
    int answer = 0;
    
    string num = Transform(n, k);
    
    vector<string> nums = Split(num, '0');
    
    
    for(int i = 0; i < nums.size(); ++i)
    {
        if (IsPrime(stol(nums[i])))
            ++answer;
    }
    
    return answer;
}