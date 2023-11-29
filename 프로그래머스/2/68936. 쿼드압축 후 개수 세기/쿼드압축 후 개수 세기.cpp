#include <string>
#include <vector>

using namespace std;

struct Count
{
    int one;
    int zero;
    
    Count(int o, int z) : one(o), zero(z) {}

    Count operator+ (const Count& other)
    {
        return Count(one + other.one, zero + other.zero);
    }
};

Count Compress(int x, int y, int n, vector<vector<int>>& arr)
{
    int size = n / 2;
    
    pair<int, int> count;
    for(int i = x; i < x + n; ++i)
    {
        for(int j = y; j < y + n; ++j)
        {
            if (arr[y][x] != arr[j][i]) {
                return Compress(x, y, size, arr) + Compress(x, y + size, size, arr) + 
                    Compress(x + size, y, size, arr) + Compress(x + size, y + size, size, arr);
            }
        }
    }
    
    return arr[y][x] == 1 ? Count(1, 0) : Count(0, 1);
}

vector<int> solution(vector<vector<int>> arr) {
    Count a = Compress(0, 0, arr.size(), arr);

    return {a.zero, a.one};
}