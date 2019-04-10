#include<iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    int n;
    while(cin >> n && n != 0){
        int* data = new int[n];
        int min = 0x7FFFFFFF, index;
        for(int i = 0; i < n; ++i){
            cin >> data[i];
            if(data[i] < min){
                min = data[i];
                index = i;
            }
        }
        int t;
        t = data[index];
        data[index] = data[0];
        data[0] = t;
        cout << data[0];
        for (int i = 1; i < n; ++i)
        {
            cout << " " << data[i];
        }
        cout << endl;
    }
    return 0;
}