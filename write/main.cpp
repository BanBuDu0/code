#include <iostream>
#include<string>
#include<vector>
using namespace std;

struct Event{
    string name;
    char time[11];
    string state;
};

int main()
{
    int payment[24];
    int n;
    for(int i = 0; i < 24; i++){
        cin >> payment[i];
    }
    cin >> n;
    vector<Event> online;
    vector<Event> offline;
    vector<Event>::iterator it;
    for(int i = 0; i < n; i++){
        Event temp;
        cin >> temp.name >> temp.time >> temp.state;
        if(temp.state.compare("on-line")){
            online.push_back(temp);
        }else{
            offline.push_back(temp);
        }
    }
    /*
    for(it = online.begin();it != online.end(); it++){
        cout << (*it).name << " " << (*it).time << " " << (*it).state << endl;
    }
    */
    for(int i = 0; i < online.size(); i++){
        cout << online[i].name;
    }

    return 0;
}
