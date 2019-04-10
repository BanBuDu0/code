#include <iostream>
#include <string>
using namespace std;

int main() {
    string s[4];
    cin >> s[0] >> s[1] >> s[2] >> s[3];
    if (s[0] == "IN" && s[1] == "IN" && s[2] == "IN" && s[3] == "IN") {
        cout << "YES" << endl;
        return 0;
    }
    int count;
    cin >> count;
    for (int i = 0; i < count; ++i) {
        string ins;
        cin >> ins;
        if (ins == "UP") {
            if (s[0] == "IN") {
                s[0] = "OUT";
            } else {
                s[0] = "IN";
            }
            if (s[1] == "IN") {
                s[1] = "OUT";
            } else {
                s[1] = "IN";
            }
            if (s[3] == "IN") {
                s[3] = "OUT";
            } else {
                s[3] = "IN";
            }
        }
        if (ins == "LEFT") {
            if (s[3] == "IN") {
                s[3] = "OUT";
            } else {
                s[3] = "IN";
            }
            if (s[0] == "IN") {
                s[0] = "OUT";
            } else {
                s[0] = "IN";
            }
            if (s[2] == "IN") {
                s[2] = "OUT";
            } else {
                s[2] = "IN";
            }
        }
        if(ins == "DOWN") {
            if (s[2] == "IN") {
                s[2] = "OUT";
            } else {
                s[2] = "IN";
            }
            if (s[1] == "IN") {
                s[1] = "OUT";
            } else {
                s[1] = "IN";
            }
            if (s[3] == "IN") {
                s[3] = "OUT";
            } else {
                s[3] = "IN";
            }
        }
        if(ins == "RIGHT") {
            if (s[0] == "IN") {
                s[0] = "OUT";
            } else {
                s[0] = "IN";
            }
            if (s[1] == "IN") {
                s[1] = "OUT";
            } else {
                s[1] = "IN";
            }
            if (s[2] == "IN") {
                s[2] = "OUT";
            } else {
                s[2] = "IN";
            }
        }
        cout << s[0] << " " << s[1] << " " << s[2] << " " << s[3] << endl;
        if (s[0] == "IN" && s[1] == "IN" && s[2] == "IN" && s[3] == "IN") {
            cout << "YES" << endl;
            return 0;
        }
    }
    if (s[0] == "IN" && s[1] == "IN" && s[2] == "IN" && s[3] == "IN") {
        ;
    } else {
        cout << "NO" << endl;
    }
}
