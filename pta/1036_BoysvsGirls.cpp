#include<iostream>
#include<vector>
using namespace std;

typedef struct {
    char name[11];
    char gender;
    char id[11];
    int grade;
}inf;


int main(){
    int n;
    cin >> n;
    vector<inf> Minfs;
    vector<inf> Finfs;
    inf tempinf;
    for(int i = 0; i < n; i ++){
        cin >> tempinf.name >> tempinf.gender >> tempinf.id >> tempinf.grade;
        if(tempinf.gender == 'M'){
            Minfs.push_back(tempinf);
        }else{
            Finfs.push_back(tempinf);
        }
    }
    int high = 0, low = 100, flag = 0, g = 0;

    if(Finfs.empty()){
        flag = 1;
        cout << "Absent" << endl;
    }else{
        for(int i = 0; i < (int)Finfs.size(); i++){
            if(Finfs[i].grade > high){
                high = Finfs[i].grade;
                tempinf = Finfs[i];
            }
        }
        cout << tempinf.name << " " << tempinf.id << endl;
         g = tempinf.grade;
    }

    if(Minfs.empty()){
        flag = 1;
        cout << "Absent" << endl;
    }else{
        for(int i = 0; i < (int)Minfs.size(); i++){
            if(Minfs[i].grade < low){
                low = Minfs[i].grade;
                tempinf = Minfs[i];
            }
        }
        cout << tempinf.name << " " << tempinf.id << endl;
    }

    if(flag == 1){
        cout << "NA" << endl;
    }else{
        cout << g - tempinf.grade << endl;
    }

    return 0;
}
