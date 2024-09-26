class MyCalendar {
public:
    set<pair<int, int>> apts;
    MyCalendar() {}
    
    bool book(int start, int end) {
        for(auto i : apts){
            if((i.first < start && i.second > start) || (i.first < end && i.second > end) || (i.first >= start && i.second <= end)) return false;
            else if(i.first > end) break;
        }
        apts.insert({start, end});
        return true;
    }
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */