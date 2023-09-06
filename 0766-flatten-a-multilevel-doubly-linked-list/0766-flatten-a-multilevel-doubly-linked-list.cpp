class Solution {
public:
    Node* solve(Node* head, Node* &tail){
        if(head == NULL)  return head;
        
        Node* mhead = head;
        Node* mtail = head;

        while(head != NULL){
            tail = head;
            // cout << head->val << " ";
            if(head->child){
                Node* next = head->next;
                Node* t = NULL;
                head->next = solve(head->child, t);
                // cout << head->val << " " << t->val << " " << endl;
                // next->val << endl;
                t->next = next;
                head->next->prev = head;
                if(next) next->prev = t;
                head->child = NULL;
                head = t->prev;
            }
            head = head->next;
        }
        return mhead;
    }
    Node* flatten(Node* head) {
        if(head == NULL) return head;
        Node* prev = NULL;
        head = solve(head, prev);
        Node* curr = head;
        return head;        
    }
};