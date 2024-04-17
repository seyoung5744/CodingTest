#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <iostream>
using namespace std;

struct Car
{
    int num;
    int totalTime;
    int inTime;
    
    Car(int n, int tt, int it)
    {
        this->num = n;
        this->totalTime = tt;
        this->inTime =it;
    }
};

vector<string> Split(string s, char del)
{
    vector<string> answer;
    stringstream ss (s);
    string temp;
    
    while(getline(ss, temp, del))
    {
        answer.push_back(temp);
    }
    
    return answer;
}

int Transform(string t)
{
    int hour = stoi(t.substr(0, 2));
    int min = stoi(t.substr(3, 2));
    
    return hour * 60 + min;
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    map<int, Car*> m;
    
    for(int i = 0; i < records.size(); ++i)
    {
        vector<string> data = Split(records[i], ' ');
        int time = Transform(data[0]);
        int carNum = stoi(data[1]);
        string cmd = data[2];
        
        if (cmd == "IN")
        {
            if (m.find(carNum) == m.end())
            {
                m.insert(make_pair(carNum, new Car(carNum, 0, time)));
            }
            else
            {
                m[carNum]->inTime = time;
            }
        }
        else
        {
            m[carNum]->totalTime += time - m[carNum]->inTime;
            m[carNum]->inTime = -1;
            
        }
    }
    
    for(auto car : m)
    {
        Car* c = car.second;
        
        if (c->inTime != -1)
        {
            c->totalTime += Transform("23:59") - c->inTime;
        }
        
        int totalTime = c->totalTime;
        int cost = fees[1];
        totalTime -= fees[0];
        
        if (totalTime > 0)
        {
            cost += totalTime / fees[2] * fees[3];
        
            if (totalTime % fees[2] != 0)
            {
                cost += fees[3];
            }
        }
        
        answer.push_back(cost);
    }
    
    return answer;
}