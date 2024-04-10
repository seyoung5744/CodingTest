#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(), phone_book.end());
    
    
    for(int i = 0; i < phone_book.size()-1 && answer; ++i)
    {
        if (phone_book[i].length() > phone_book[i+1].length())
            continue;
        for(int j = 0; j < phone_book[i].length() && answer; ++j)
        {
            if (phone_book[i][j] != phone_book[i+1][j])
                break;
            
            if (j == phone_book[i].length()-1)
                answer = false;
        }
    }
    
    return answer;
}