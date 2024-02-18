class Solution {
public:
    Node* connect(Node* root) {
        if(!root) return root;

        queue<Node*> q;
        q.push(root);
        q.push(NULL);

        Node* prev = NULL, *front = NULL;
        while(!q.empty()){
            front = q.front();
            q.pop();
            if(front == NULL){
                if(q.empty()) break;
                else q.push(NULL);

                front = q.front();
                q.pop();
                prev = NULL;
            }
            
            if(front->left != NULL){
                q.push(front->left);
                if(prev != NULL) prev->next = front->left;
                prev = front->left;
            }
            if(front->right != NULL) {
                q.push(front->right);
                if(prev != NULL) prev->next = front->right;
                prev = front->right;
            }
        }

        return root;
    }
};