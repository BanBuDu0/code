#include<iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* res = (ListNode *)malloc(sizeof(ListNode));
        ListNode* p = res, *cur = head;
        res -> next = head;
        for(int i = 1; cur; ++i){
            if(i % k == 0){
                p = reverseOneGroup(p, cur -> next);
                cur = pre -> next;
            }else{
                cur = cur -> next;
            }
        }
        return res -> next;
    }
    ListNode* reverseOneGroup(ListNode* pre, ListNode* next){
        ListNode* last = pre -> next;
        ListNode* cur = last -> next;
        while(cur != next){
            last -> next = cur -> next;
            cur -> next = pre -> next;
            pre -> next = cur;
            cur = last -> next;
        }
        return last;
    }
};