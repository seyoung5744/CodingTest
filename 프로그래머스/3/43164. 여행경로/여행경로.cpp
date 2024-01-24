#include <string>
#include <vector>
#include <map>
#include <set>

using namespace std;

vector<string> answer;
map<string, int> s2i;
map<int, string> i2s;
int maxLength;

void dfs(vector<vector<int>> m, vector<string> result)
{
    if (answer.size() != 0)
        return;

    if (result.size() == maxLength + 1)
    {
        answer = result;
        return;
    }


    string cur = result.back();
    int curIdx = s2i[cur];

    for (int i = 0; i < m.size(); ++i)
    {
        if (m[curIdx][i] <= 0)
            continue;

        --m[curIdx][i];
        result.push_back(i2s[i]);
        dfs(m, result);

        ++m[curIdx][i];
        result.pop_back();
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    set<string> airports;
    maxLength = tickets.size();

    for (int i = 0; i < tickets.size(); ++i)
    {
        airports.insert(tickets[i][0]);
        airports.insert(tickets[i][1]);
    }

    int num = 0;

    for (auto& str : airports)
    {
        s2i[str] = num;
        i2s.insert(make_pair(num, str));
        ++num;
    }


    vector<vector<int>> m(airports.size(), vector<int>(airports.size(), 0));

    for (int i = 0; i < tickets.size(); ++i)
    {
        string from = tickets[i][0];
        string to = tickets[i][1];

        ++m[s2i[from]][s2i[to]];
    }

    dfs(m, { "ICN" });

    return answer;
}