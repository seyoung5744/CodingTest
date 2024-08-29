#include <string>
#include <vector>
#include <map>

using namespace std;

vector<char> people = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
vector<int> pos = { 1, 2, 3, 4, 5, 6, 7, 8 };
int answer = 0;

bool check(map<char, int>& result, vector<string>& data)
{
    for (int i = 0; i < data.size(); ++i)
    {
        char p1 = data[i][0];
        char p2 = data[i][2];

        char command = data[i][3];
        int dis = data[i][4] - '0';

        if (command == '>')
        {
            if (abs(result[p1] - result[p2]) - 1 <= dis)
                return false;
        }
        else if (command == '=')
        {
            if (abs(result[p1] - result[p2]) - 1 != dis)
                return false;
        }
        else
        {
            if (abs(result[p1] - result[p2]) - 1 >= dis)
                return false;
        }
    }

    return true;
}

void dfs(map<char, int> result, vector<bool> visited, int pIndex, vector<string>& data)
{
    if (pIndex >= people.size())
    {
        if (check(result, data))
            ++answer;

        return;
    }

    for (int i = 0; i < pos.size(); ++i)
    {
        if (visited[i] == true)
            continue;

        result[people[pIndex]] = pos[i];
        visited[i] = true;
        dfs(result, visited, pIndex + 1, data);
        visited[i] = false;
    }
}

int solution(int n, vector<string> data) {
    answer = 0;

    dfs(map<char, int>(), vector<bool>(people.size(), false), 0, data);

    return answer;
}