class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head) return NULL;
        Node *curr = head, *curr2 = NULL, *ans = NULL, *tail = NULL;
        unordered_map<Node*, Node*> mp;
        while(curr){
            if(ans == NULL){
                ans = new Node(curr->val);
                tail = ans;
                mp[curr] = ans;
            }
            else{
                tail->next = new Node(curr->val);
                tail = tail->next;
                mp[curr] = tail;
            }
            curr = curr->next;
        }        
        curr = head;
        curr2 = ans;
        while(curr){
            if(curr->random) curr2->random = mp[curr->random];
            curr = curr->next;
            curr2 = curr2->next;
        }

        return ans;
    }
};