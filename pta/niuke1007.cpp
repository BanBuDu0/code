#include<iostream>
#include<vector>
#include<algorithm>
#include<stdio.h>
#include<string.h>
using namespace std;

struct record {
    int id;
    char name[10];
    int grade;
};

bool comp1(record r1, record r2) {
    return r1.id < r2.id;
}

bool comp2(record r1, record r2) {
    int i = strcmp(r1.name, r2.name);
    if(i < 0) {
        return true;
    } else if(i > 0) {
        return false;
    }
    return comp1(r1, r2);
}

bool comp3(record r1, record r2) {
    if(r1.grade == r2.grade) {
        return comp1(r1, r2);
    }
    return r1.grade < r2.grade;
}
int main() {
    int n, c;
    cin >> n >> c;
    vector<record> records(n);
    //record *records = new record[n];
    for (int i = 0; i < n; i++) {
        cin >> records[i].id >> records[i].name >> records[i].grade;
    }
    switch(c) {
    case 1:
        sort(records.begin(), records.end(), comp1);
        break;
    case 2:
        sort(records.begin(), records.end(), comp2);
        break;
    case 3:
        sort(records.begin(), records.end(), comp3);
        break;
    }

    for (int i = 0; i < n; i++) {
        printf("%06d %s %d\n", records[i].id, records[i].name, records[i].grade);
    }
}
