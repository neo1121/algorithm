struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* root = new ListNode();
        ListNode* next = root;
        int v = 0;
        while (l1 != nullptr && l2 != nullptr) {
            v += l1->val + l2->val;
            next->next = new ListNode(v % 10);
            v /= 10;
            next = next->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        while (l1 != nullptr) {
            v += l1->val;
            next->next = new ListNode(v % 10);
            v /= 10;
            next = next->next;
            l1 = l1->next;
        }
        while (l2 != nullptr) {
            v += l2->val;
            next->next = new ListNode(v % 10);
            v /= 10;
            next = next->next;
            l2 = l2->next;
        }
        if (v > 0) {
            next->next = new ListNode(v);
        }
        return root->next;
    }
};