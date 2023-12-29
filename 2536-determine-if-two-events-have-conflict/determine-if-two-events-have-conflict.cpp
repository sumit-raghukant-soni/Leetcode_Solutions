class Solution {
public:
    bool solve(vector<string>& event1, vector<string>& event2){
        string sh1 = event1[0].substr(0, 2), sh2 = event2[0].substr(0, 2);
        string sm1 = event1[0].substr(3, 2), sm2 = event2[0].substr(3, 2);
        string eh1 = event1[1].substr(0, 2), eh2 = event2[1].substr(0, 2);
        string em1 = event1[1].substr(3, 2), em2 = event2[1].substr(3, 2);

        if(sh1 == eh1){
            if(eh1 == sh2 && sm1 <= sm2 && sm2 <= em1) return true;
        }
        else if(sh1 < sh2 && sh2 < eh1){
            return true;
        }
        else if(sh1 <= sh2 && sh2 < eh1){
            return sm1 <= sm2;
        }
        else if(sh1 < sh2 && sh2 <= eh1){
            return sm2 <= em1;
        }

        return false;
    }
    bool haveConflict(vector<string>& event1, vector<string>& event2) {
        return solve(event1, event2) || solve(event2, event1);
    }
};