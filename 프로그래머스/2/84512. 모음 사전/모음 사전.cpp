#include <string>
#include <vector>
#include <map>
#include <cmath>
#include <iostream>
using namespace std;

map<char, int> mapping = {{'A',0}, {'E',1}, {'I',2}, {'O',3}, {'U',4}};

int solution(string word) {
    int answer = 0;
    
    int dis = 781;
    
    for(int i = 0; i < word.length(); ++i)
    {
        answer += dis * mapping[word[i]] + 1;
        dis = (dis - 1) / 5;
    }
    return answer;
}