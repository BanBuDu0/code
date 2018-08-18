#include<iostream>
#include<string.h>
#include<vector>
#include<stdio.h>
#include<stdlib.h>
#include<algorithm>
using namespace std;

// pat ac,  牛客没过
typedef struct {
    string id;
    string title;
    string author;
    string keyWord;
    string publisher;
    string publishedYear;

} bookInfo;


bool cmp(bookInfo a, bookInfo b){
    return a.id < b.id;
}

int main(int argc, char const *argv[]) {
    int n, m;
    cin >> n;
    bookInfo *books = new bookInfo[n];
    string s;
    string temp = "";
    for(int i = 0; i < n; ++i) {
        cin >> books[i].id;
        getchar();
        getline(cin, books[i].title, '\n');
        getline(cin, books[i].author, '\n');
        do {
        	cin >> s;
        	temp += s;
        	temp += " ";
        } while (cin.get() != '\n');
        books[i].keyWord = temp;
        temp = "";
        getline(cin, books[i].publisher, '\n');
        cin >> books[i].publishedYear;
    }

    sort(books, books+n, cmp);
    cin >> m;
    getchar();
    vector<string> pur;
    vector<int> out;
    for(int i = 0; i < m; ++i) {
        getline(cin, temp, '\n');
        pur.push_back(temp);
    }
    for(int i = 0; i < m; ++i) {
        int flag = 0;
        cout << pur[i] << endl;
        int a = atoi(pur[i].substr(0, 1).c_str());
        switch(a) {
        case 1:
            for(int j = 0; j < n; ++j) {
                if(books[j].title == pur[i].substr(3)) {
                    cout << books[j].id << endl;
                    flag += 1;
                }
            }
            break;
        case 2:
            for(int j = 0; j < n; ++j) {
                if(books[j].author.find(pur[i].substr(3)) != -1) {
                    cout << books[j].id << endl;
                    flag += 1;
                }
            }
            break;
        case 3:
            for(int j = 0; j < n; ++j) {
                if(books[j].keyWord.find(pur[i].substr(3)) != -1) {
                    cout << books[j].id << endl;
                    flag += 1;
                }
            }
            break;
        case 4:
            for(int j = 0; j < n; ++j) {
                if(books[j].publisher == pur[i].substr(3)) {
                    cout << books[j].id << endl;
                    flag += 1;
                }
            }
            break;
        case 5:
            for(int j = 0; j < n; ++j) {
                if(books[j].publishedYear == pur[i].substr(3)) {
                    cout << books[j].id << endl;
                    flag += 1;
                }
            }
            break;
        }
        if(flag == 0) {
            cout << "Not Found" << endl;
        }
    }

    return 0;
}
