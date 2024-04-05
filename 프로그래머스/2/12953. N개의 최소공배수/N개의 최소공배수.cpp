#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> arr) {
    int answer = 0;
    sort(arr.begin(), arr.end());
    int max = arr.back();
    
    while(true)
    {
        bool flag = true;
        for(int i = 0; i < arr.size() && flag; ++i)
        {
            if (max % arr[i] != 0)
                flag = false;
        }
        
        if (flag)
            break;
        
        max += arr.back();
    }
    
    return max;
}