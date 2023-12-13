#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct Person
{
    int inTime;
    int outTime;
    
    Person(int it, int ot) : inTime(it), outTime(ot){}
};

struct Cmp
{
    bool operator()(Person* a, Person* b)
    {
        return a->outTime > b->outTime;
    }
};

int Transform(string time)
{
    int hour = stoi(time.substr(0, 2));
    int minute = stoi(time.substr(3, 2));
    
    return hour * 60 + minute;
}


int solution(vector<vector<string>> book_time) {
    int answer = 0;
    priority_queue<Person*, vector<Person*>, Cmp> pq;
    
    vector<Person*> bt;
    
    for(int i = 0; i < book_time.size(); ++i)
    {
        int it = Transform(book_time[i][0]);
        int ot = Transform(book_time[i][1]);
        
        bt.emplace_back(new Person(it, ot));
    }
    
    sort(bt.begin(), bt.end(), [](Person* a, Person* b){
        return a->inTime < b->inTime;
    });
    
    for(int i = 0; i < bt.size(); ++i)
    {
        if (pq.empty())
        {
            pq.push(bt[i]);
        }
        else
        {
            while(!pq.empty())
            {
                if (pq.top()->outTime + 10 <= bt[i]->inTime)
                {
                    pq.pop();
                }
                else
                {
                    break;
                }
            }
            
            pq.push(bt[i]);
        }
        
        answer = answer < pq.size() ? pq.size() : answer;
    }
    
    
    return answer;
}