#include <string>
#include <vector>
#include <cctype>
#include <iostream>
#include <algorithm>

using namespace std;

struct File
{
    string fileName;
    string head;
    string number;
    string tail;
    
    File(string fn, string h, string n, string t) 
        : fileName(fn), head(h), number(n), tail(t) {}
};

vector<string> solution(vector<string> files) {
    vector<string> answer;
    
    vector<File> fileList;
    for(int i = 0; i < files.size(); ++i)
    {
        vector<string> file (3, "");
        int target = 0;
        for(char ch: files[i])
        {
            if (target == 0)
            {
                if (!isdigit(ch))
                {
                    file[target] += tolower(ch);
                    continue;
                }
                else
                {
                    ++target;
                }
            }
            
            if (target == 1)
            {
                if (file[target].length() == 5)
                    ++target;
                else
                {
                    if (isdigit(ch))
                    {
                        file[target] += ch;
                    }
                    else
                    {
                        ++target;
                    } 
                }
            }
            
            if (target == 2)
            {
                file[target] += ch;
            }
        }
        
        fileList.emplace_back(File(files[i], file[0], file[1], file[2]));
    }
    
    stable_sort(fileList.begin(), fileList.end(), [](File a, File b){
        if (a.head == b.head)
        {
            return stoi(a.number) < stoi(b.number);
        }
        
        return a.head < b.head;
    });
    
    for(int i = 0; i < fileList.size(); ++i)
    {
        answer.emplace_back(fileList[i].fileName);
    }
    
    return answer;
}