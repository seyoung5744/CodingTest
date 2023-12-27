#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> cards) {
    int answer = 0;
    vector<int> parent(cards.size());
    vector<bool> visited(cards.size(), false);
    for(int i = 0; i < parent.size(); ++i)
    {
        parent[i] = i;
    }
    
    priority_queue<int> pq;
    for(int i = 0; i < cards.size(); ++i)
    {
        if (visited[i])
            continue;
        
        visited[i] = true;
        int count = 1;
        int next = cards[i] - 1;     
        while(!visited[next])
        {
            ++count;
            visited[next] = true;
            next = cards[next] - 1;
        }
        
        pq.push(count);
    }
    
    if (pq.size() == 1)
        return 0;
    else
    {
        int max = pq.top();
        pq.pop();
        return max * pq.top();
    }
    
}