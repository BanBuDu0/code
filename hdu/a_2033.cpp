#include<iostream>
#include<cstdio>
using namespace std;

int main(){
    int n;
    while(cin >> n){
        while(n--){
            int AH,AM,AS,BH,BM,BS;
            int flag = 0;
            scanf("%d%d%d%d%d%d", &AH,&AM,&AS,&BH,&BM,&BS);
            AS+=BS;
            if(AS >= 60){
                AS-=60;
                flag++;
            }
            AM+= BM + flag;
            flag = 0;
            if(AM >= 60){
                AM -= 60;
                flag ++;
            }
            AH+=flag + BH;
            cout << AH << " " << AM << " " << AS << endl;
        }
    }
}
