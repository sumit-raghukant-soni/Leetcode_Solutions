class Linklist{
    public:
    int val, key;
    Linklist* next;
    Linklist(int key, int val){
        this->key = key;
        this->val = val;
        next = NULL;
    }
};
class MyHashMap {
public:
    Linklist* root;
    MyHashMap() {
        root = new Linklist(-1, -1);
    }
    
    void put(int key, int value) {
        Linklist *curr = root;
        while(curr){
            if(curr->key == key){
                curr->val = value;
                return;
            }
            curr = curr->next;
        }

        curr = new Linklist(key, value);
        curr->next = root->next;
        root->next = curr;
    }
    
    int get(int key) {
        Linklist *curr = root;
        while(curr){
            if(curr->key == key) return curr->val;
            curr = curr->next;
        }
        return -1;
    }
    
    void remove(int key) {
        Linklist *curr = root;
        while(curr){
            if(curr->next && curr->next->key == key){
                curr->next = curr->next->next;
                return;
            }
            curr = curr->next;
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */