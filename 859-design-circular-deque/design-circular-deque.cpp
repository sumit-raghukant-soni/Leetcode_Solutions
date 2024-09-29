class MyCircularDeque {
public:
    vector<int> arr;
    int front, rear, sz;
    MyCircularDeque(int k) {
        sz = k;
        arr = vector<int>(sz, -1);
        front = rear = -1;
    }

    bool insertFront(int value) {
        if ((rear + 1) % sz == front)
            return false;
        front--;
        if(front == -2) front = 0;
        if (front == -1)
            front = sz - 1;
        if(rear == -1) rear = front;
        arr[front] = value;
        // cout << front << " " << rear << endl;
        return true;
    }

    bool insertLast(int value) {
        if ((rear + 1) % sz == front)
            return false;
        rear = (rear + 1) % sz;
        if(front == -1) front = rear;
        arr[rear] = value;
        // cout << front << " " << rear << endl;
        return true;
    }

    bool deleteFront() {
        if (front == -1)
            return false;
        if(front == rear){
            front = rear = -1;
            return true;
        }
        front++;
        if (front == sz && rear != -1)
            front = 0;
        // cout << front << " " << rear << endl;
        return true;
    }

    bool deleteLast() {
        if (rear == -1)
            return false;
        if(front == rear){
            front = rear = -1;
            return true;
        }
        rear--;
        if (rear == -1 && front != -1) {
            rear = sz - 1;
        }
        // cout << front << " " << rear << endl;
        return true;
    }

    int getFront() {
        if (front == -1)
            return -1;
        return arr[front];
    }

    int getRear() {
        if (rear == -1)
            return -1;
        return arr[rear];
    }

    bool isEmpty() { return front == -1 && rear == -1; }

    bool isFull() { return (rear + 1) % sz == front; }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */