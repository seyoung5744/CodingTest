#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> GetDivisor(vector<int> array)
{
    vector<int> answer;
    int max = *array.begin();
    
    for(int i = 2; i <= max; ++i)
    {
        if (max % i == 0)
        {
            bool flag = true;
            for (int j = 1; j < array.size() && flag; ++j)
            {
                if (array[j] % i == 0)
                    continue;
                
                flag = false;
            }
            
            if (flag)
            {
                answer.push_back(i);
            }
        }
    }
    
    return answer;
}

int solution(vector<int> arrayA, vector<int> arrayB) {
    int answer = 0;
    sort(arrayA.begin(), arrayA.end());
    sort(arrayB.begin(), arrayB.end());
    
    
    vector<int> a = GetDivisor(arrayA);
    vector<int> b = GetDivisor(arrayB);
    
    for(int i = 0; i < b.size(); ++i)
    {
        //cout << b[i] << endl;
    }
     
    for(int i = a.size() - 1; i >= 0; --i)
    {
        if (find(b.begin(), b.end(), a[i]) == b.end())
        {
            bool flag = true;
            
            for(int j = 0; j < arrayB.size() && flag; ++j)
            {
                if (arrayB[j] % a[i] == 0)
                {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
            {
                answer = a[i];
                break;
            }
        }
    }
    
    for(int i = b.size() - 1; i >= 0; --i)
    {
        if (b[i] < answer)
            break;
        
        if (find(a.begin(), a.end(), b[i]) == a.end())
        {
            bool flag = true;
            for(int j = 0; j < arrayA.size() && flag; ++j)
            {
                if (arrayA[j] % b[i] == 0)
                {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
            {
                cout << b[i] << endl;
                answer = b[i];
                break;
            }
        }
    }
    
    return answer;
}