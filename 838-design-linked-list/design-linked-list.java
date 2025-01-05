class MyLinkedList {
    LinkNode head, tail;
    public MyLinkedList() {
        head = tail = null;
    }
    
    public int get(int index) {
        if(head == null) return -1;
        LinkNode tmp = head;

        for(int i=0; i<index && tmp != null; i++){
            tmp = tmp.next;
        }
        
        if(tmp == null) return -1;
        return tmp.val;
    }
    
    public void addAtHead(int val) {
        LinkNode tmp = new LinkNode(val);
        tmp.next = head;
        if(tail == null) head = tail = tmp;
        else head = tmp;

        // print();
    }
    
    public void addAtTail(int val) {
        LinkNode tmp = new LinkNode(val);
        if(head == null){
            head = tail = tmp;
            return;
        }
        tail.next = tmp;
        tail = tmp;

        // print();
    }
    
    public void addAtIndex(int index, int val) {
        LinkNode tmp = new LinkNode(val);
        
        if(index == 0){
            tmp.next = head;
            head = tmp;
        }
        else{
            LinkNode curr = head, prev = null;
            while(--index >= 0 && curr != null){
                prev = curr;
                curr = curr.next;
            }

            if(index != -1) return;
            LinkNode next = prev.next;
            prev.next = tmp;
            tmp.next = next;
            if(next == null) tail = tmp;
        }

        // print();
    }
    
    public void deleteAtIndex(int index) {
        if(head == null) return;
        
        if(index == 0) head = head.next;
        else{
            LinkNode curr = head, prev = null;        
            while(--index >= 0 && curr != null){
                prev = curr;
                curr = curr.next;
            }
            
            if(prev.next != null){
                prev.next = curr.next;
                if(curr.next == null) tail = prev;
            }
        }

        // print();
    }

    public void print(){
        LinkNode tmp = head;

        while(tmp != null){
            System.out.print(tmp.val + ", ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}


class LinkNode{
    public int val;
    public LinkNode next;

    LinkNode(int val){
        this.val = val;
        next = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */