class Solution {
public:
    void reverseString(vector<char>& str) {
        int e = str.size()-1, s = 0;
        while(e > s){
            swap(str[s++], str[e--]);
        }
    }
};