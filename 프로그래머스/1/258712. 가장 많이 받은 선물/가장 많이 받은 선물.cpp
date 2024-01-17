#include <string>
#include <vector>
#include <map>
#include <sstream>
using namespace std;

vector<string> split(string str, char del)
{
    vector<string> answer;
    stringstream ss (str);
    string temp;
    
    while(getline(ss, temp, del))
    {
        answer.push_back(temp);
    }
    
    return answer;
}

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    vector<vector<int>> exel (friends.size(), vector<int>(friends.size(), 0));
    
    map<string, int> p;
    for(int i = 0; i< friends.size(); ++i)
    {
        p.insert(make_pair(friends[i], i));
    }
    
    for(int i = 0; i < gifts.size(); ++i)
    {
        vector<string> temp = split(gifts[i], ' ');
        int giver = p[temp[0]];
        int receiver = p[temp[1]];
        
        ++exel[giver][receiver];
    }
    
    vector<int> point (friends.size(), 0);
    
    for(int i = 0; i < friends.size(); ++i)
    {
        int gPoint = 0;
        for(int j = 0; j < friends.size(); ++j)
        {
            gPoint += exel[i][j];
        }
        
        int rPoint = 0;
        for(int j = 0; j < friends.size(); ++j)
        {
            rPoint += exel[j][i];
        }
        
        point[i] = gPoint - rPoint;
    }
    
    for(int i = 0; i < friends.size(); ++i)
    {
        int count = 0;
        for(int j = 0; j < friends.size(); ++j)
        {
            if (i == j)
                continue;
            
            if (exel[i][j] == exel[j][i])
            {
                if (point[i] > point[j])
                {
                    ++count;
                }
            }
            else
            {
                if (exel[i][j] > exel[j][i])
                {
                    ++count;
                }
            }
        }
        
        if (answer < count)
        {
            answer = count;
        }
    }
    
    return answer;
}