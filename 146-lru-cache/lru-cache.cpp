class LRUCache {
public:
    class Node{
        public:
        int key, val;
        Node *prev, *next;
        Node(int k, int v){
            key = k;
            val = v;
            prev = next = NULL;
        }
    };
    Node *head = new Node(-1, -1), *tail = new Node(-1, -1);
    int sz, occupied;
    unordered_map<int, Node*> mp;
    LRUCache(int capacity) {
        occupied = 0;
        sz = capacity;
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        // print();
        if(mp.find(key) == mp.end()) return -1;
        Node* tmp = mp[key];
        int value = tmp->val;
        deleteNode(tmp);
        addNode(key, value);
        return value;
    }
    
    void put(int key, int value) {
        // print();
        if(mp.find(key) != mp.end()){
            Node* del = mp[key]; 
            mp.erase(del->key);
            deleteNode(del);
            occupied--;
        }
        if(occupied == sz){
            Node* tmp = tail->prev;
            mp.erase(tmp->key);
            deleteNode(tmp);
            occupied--;
        }
        occupied++;
        addNode(key, value);
    }

    void deleteNode(Node* tmp){
        tmp->prev->next = tmp->next;
        tmp->next->prev = tmp->prev;
        mp.erase(tmp->key);
        delete tmp;
    }

    void addNode(int key, int value){
        Node* tmp = new Node(key, value);
        tmp->next = head->next;
        head->next->prev = tmp;
        head->next = tmp;
        tmp->prev = head;
        mp[key] = tmp;
    }

    void print(){
        Node *curr = head;
        while(curr){
            cout << curr->key << ":" << curr->val << " ";
            curr = curr->next;
        }
        cout << endl;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */