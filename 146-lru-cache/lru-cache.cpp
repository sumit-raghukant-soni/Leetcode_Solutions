class Node{
    public:
    int key, val;
    Node *prev, *next;
    Node(int k, int v){
        key = k, val = v;
        prev = next = NULL;
    }
};
class LRUCache {
public:
    unordered_map<int, Node*> mp;
    Node *head, *tail;
    int sz, cap;
    LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = head;
        sz = 0;
        cap = capacity;
        // cout << "New " << cap << endl;
    }

    void print(){
        Node* curr = head;
        cout << sz << endl;
        while(curr){
            cout << curr->key << " ";
            curr = curr->next;
        }
        cout << endl;
    }
    
    int get(int key) {
        // cout << "get " << key << endl;
        if(mp.find(key) == mp.end()) return -1;

        if(tail->key != key){
            // cout << "prev key " << mp[key]->prev->key << endl;
            if(mp[key]->prev) mp[key]->prev->next = mp[key]->next;
            if(mp[key]->next) mp[key]->next->prev = mp[key]->prev;
            tail->next = mp[key];
            mp[key]->prev = tail;
            mp[key]->next = NULL;
            tail = tail->next;
        }
        // print();
        return tail->val;
    }
    
    void put(int key, int value) {
        // cout << "put " << key << endl;
        if(mp.find(key) != mp.end()){
            mp[key]->val = value;
            get(key);
            return;
        }
        if(sz == cap){
            mp.erase(head->next->key);
            head->next = head->next->next;
            if(head->next) head->next->prev = head;
            else tail = head;
        }
        else sz++;

        tail->next = new Node(key, value);
        tail->next->prev = tail;
        tail = tail->next;
        mp[key] = tail;
        // print();
    }
};