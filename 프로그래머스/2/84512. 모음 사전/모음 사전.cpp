#include <string>
#include <vector>
#include <map>
#include <cmath>
#include <iostream>
using namespace std;

map<char, int> m = {{'A', 0}, {'E', 1}, {'I', 2}, {'O', 3}, {'U', 4}};

int solution(string word) {
    int answer = 0;
    
    int c = word.length();
    
    int max = 0;
    for(int i = 0; i < 5; ++i){
        max += pow(5, i);
    }
    
    for(int i = 0; i < word.size(); ++i){
        answer += m[word[i]] * max + 1;
        max -= pow(5, 4-i);
    }
    
    return answer;
}