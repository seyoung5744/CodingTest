#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

vector<string> Split(string s, char del)
{
    vector<string> answer;

    stringstream ss(s);
    string temp;

    while (getline(ss, temp, del))
    {
        answer.push_back(temp);
    }

    return answer;

}

vector<vector<string>> infos = { { "cpp", "java", "python", "-" },
                                { "backend", "frontend","-" },
                                { "junior", "senior", "-" },
                                { "pizza", "chicken", "-" } };

map<string, vector<int>> m;


int Count(string key, int score)
{
    vector<int> list = m[key];

    int answer = 0;

    for (int i = 0; i < list.size(); ++i)
    {
        if (list[i] >= score)
            ++answer;
    }

    return answer;
}

void MakeKey(vector<string>& temp, string key, int depth)
{
    if (depth == temp.size() - 1)
    {
        if (m.find(key) == m.end())
        {
            m.insert(make_pair(key, vector<int>()));
        }

        m[key].push_back(stoi(temp[depth]));

        return;
    }

    MakeKey(temp, key + temp[depth], depth + 1);
    MakeKey(temp, key + "-", depth + 1);
}

vector<int> solution(vector<string> info, vector<string> query) {
    vector<int> answer;

    for (int i = 0; i < info.size(); ++i)
    {
        vector<string> temp = Split(info[i], ' ');

        int score = stoi(temp[4]);

        MakeKey(temp, "", 0);
    }

    for (int i = 0; i < query.size(); ++i)
    {
        vector<string> temp = Split(query[i], ' ');
        string key = "";

        for (int j = 0; j < 7; ++j)
        {
            if (temp[j] != "and")
                key += temp[j];
        }

        int score = stoi(temp[7]);
        int count = Count(key, score);

        answer.push_back(count);
    }


    return answer;
}