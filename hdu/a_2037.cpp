#include<iostream>
#include<algorithm>
using namespace std;

struct Section{
    int x, y;
}Section;

bool cmp(Section a, Section b){
    if(a.x != b.x){
        return a.x > b.x;
    }else{
        return a.y < b.y;
    }
}

int main(){
    int n;
    while(cin >> n && n != 0){
        Section* s = new Section[n];
        for(int i = 0; i < n; ++i){
            cin >> s[i].x >> s[i].y;
        }
        sort(s, s + n, cmp);
        int res = 1;
        int left = s[0].x;
        for(int i = 1; i < n; ++i){
            if(s[i].y < left){
                left = s[i].x;
                ++res;
            }
        }
        cout << res << endl;


    }
}