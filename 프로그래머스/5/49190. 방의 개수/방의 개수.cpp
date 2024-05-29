#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <map>
#include <queue>
#include <cmath>
using namespace std;

vector<int> dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
vector<int> dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

struct Node
{
    vector<Node*> linked;

    Node()
    {
        linked = vector<Node*>(8, nullptr);
    }
};

class Graph
{
public:
    Node* Start;

    Graph()
    {
        Start = new Node();
    }
};

int solution(vector<int> arrows) {
    int answer = 0;

    Graph* g = new Graph();
    map<pair<int, int>, Node*> m;

    Node* curNode = g->Start;
    int curX = 0;
    int curY = 0;

    m.insert(make_pair(make_pair(curX, curY), curNode));

    for (int i = 0; i < arrows.size(); ++i)
    {
        for (int count = 0; count < 2; ++count)
        {
            int nx = curX + dx[arrows[i]];
            int ny = curY + dy[arrows[i]];

            if (m.find(make_pair(nx, ny)) == m.end())
            {
                Node* newNode = new Node();
                m.insert(make_pair(make_pair(nx, ny), newNode));

            }
            else if (curNode->linked[arrows[i]] == nullptr)
            {
                ++answer;
            }
            
            curNode->linked[arrows[i]] = m[make_pair(nx, ny)];
            m[make_pair(nx, ny)]->linked[(arrows[i] + 4) % 8] = curNode;
            curNode = m[make_pair(nx, ny)];
            curX = nx;
            curY = ny;
        }
    }

    return answer;
}