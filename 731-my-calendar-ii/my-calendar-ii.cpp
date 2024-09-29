class MyCalendarTwo {
public:
    set<pair<int, int>> first, second;
    MyCalendarTwo() {
        
    }
    
    bool book(int start, int end) {
        // cout << "first" << endl;
        // for(auto i : first){
        //     cout << i.first << ":" << i.second << ", ";
        // }
        // cout << endl << "Second" << endl;
        // for(auto i : second){
        //     cout << i.first << ":" << i.second << ", ";
        // }
        // cout << endl;

        for(auto i : second){
            if((i.first < start && start < i.second) || (i.first < end && end < i.second) || (i.first >= start && end >= i.second)){
                return false;
            }
            else if(i.first > end) break;
        }

        for(auto i : first){
            if((i.first < start && start < i.second) || (i.first < end && end < i.second) || (i.first >= start && end >= i.second)){
                second.insert({max(start, i.first), min(end, i.second)});
            }
            else if(i.first > end) break;
        }

        first.insert({start, end});
        return true;
    }
};

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo* obj = new MyCalendarTwo();
 * bool param_1 = obj->book(start,end);
 */