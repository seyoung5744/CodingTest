#include <string>
#include <vector>

using namespace std;

bool IsValid(string w)
{
    int count = 0;
    for(int i = 0; i < w.length(); ++i)
    {
        if (w[i] == '(')
            ++count;
        else
            --count;
        
        if (count < 0)
            return false;
    }
    
    return true;
}

void Split(string original, string& u, string& v)
{
    int count = 0;
    int splitIndex = 0;
    for(int i = 0; i < original.length(); ++i)
    {
        if (original[i] == '(')
            ++count;
        else
            --count;
        
        if (count == 0)
        {
            splitIndex = i;
            break;
        }
    }
    
    u = original.substr(0, splitIndex+1);
    v = original.substr(splitIndex+1);
}

string Recursive(string p)
{
    if (p.length() == 0)
        return "";
    
    string u = "";
    string v = "";
    Split(p, u, v);
    
    if (IsValid(u))
    {
        return u + Recursive(v);
    }
    else
    {
        string temp = "(";
        
        temp += Recursive(v);
        temp += ')';
        
        for(int i = 1; i < u.length() - 1; ++i)
        {
            if (u[i] == '(')
                temp += ')';
            else
                temp += '(';
        }
        
        
        return temp;    
    }
}

string solution(string p) {
    string answer = Recursive(p);
 
    return answer;
}