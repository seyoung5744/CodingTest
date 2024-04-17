#include <string>
#include <vector>
#include <map>
using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    map<char, int> m;
    
    for(int i = 0; i <skill.length(); ++i)
    {
        m[skill[i]] = i;
    }
    
    
    
    for(int i = 0; i <skill_trees.size(); ++i)
    {
        int cur = 0;
        bool flag = true;
        for(int j = 0; j < skill_trees[i].length(); ++j)
        {
            if (m.find(skill_trees[i][j]) == m.end())
                continue;
            
            if (m[skill_trees[i][j]] > cur)
            {
                flag = false;
                break;
            }
            
            if (m[skill_trees[i][j]] == cur)
            {
                ++cur;
            }
        }
        
        if (flag)
            ++answer;
    }
    return answer;
}