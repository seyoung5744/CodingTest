#include <string>
#include <vector>
#include <cctype>
#include <algorithm>
#include <iostream>
using namespace std;
struct File
{
    
    vector<string> name;
    string origin;
    File(string o) : origin(o) 
    {
        name = vector<string>(3, "");
    }
};

vector<string> solution(vector<string> files) {
    vector<string> answer;
    vector<File*> f;
    for(int i = 0; i < files.size(); ++i)
    {
        int target = 0;
        File* temp = new File(files[i]);
        for(int j = 0; j < files[i].length(); ++j)
        {
            if (target == 0 && isdigit(files[i][j]))
                ++target;
            else if (target == 1 && (isdigit(files[i][j]) == false || temp->name[target].length() == 5))
                ++target;
            
            if (target == 0)
                temp->name[target] += tolower(files[i][j]);
            else
                temp->name[target] += files[i][j];
        }
        
        cout << temp->origin << " " << temp->name[0] << " " << temp->name[1] << " " << temp->name[2] << " " << endl;
        
        f.push_back(temp);
    }
    
    stable_sort(f.begin(), f.end(), [](File* a, File* b){
        if (a->name[0] == b->name[0])
            return stoi(a->name[1]) < stoi(b->name[1]);
        
        return a->name[0] < b->name[0];
    });
    
    for(int i = 0; i < f.size(); ++i)
    {
        answer.push_back(f[i]->origin);
    }
    
    return answer;
}