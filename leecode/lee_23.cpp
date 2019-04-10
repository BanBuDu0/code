/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        return recursion(lists, 0, lists.size() - 1);
    }
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *res = (ListNode *)malloc(sizeof(ListNode));
        if(l1 == NULL && l2 == NULL){
            return NULL;
        }else if(l1 == NULL){
            return l2;
        }else if(l2 == NULL){
            return l1;
        }
        ListNode *p = l1, *q = l2, *t = res;
        while(p != NULL && q != NULL){
            if(p -> val > q -> val){
                t -> next = q;
                t = t -> next;
                q = q -> next;
            }else{
                t -> next = p;
                t = t -> next;
                p = p -> next;
            }
        }
        if(p != NULL){
            t -> next = p;
        }
        if(q != NULL){
            t -> next = q;
        }
        return res -> next;
    }

    ListNode* recursion(vector<ListNode*>& lists, int start, int end){
        if(start > end) return NULL;
        if(start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode *left = recursion(lists, start, mid);
        ListNode *right = recursion(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
};