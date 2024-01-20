class Solution {
public:
    int strStr(string haystack, string needle) {
        int sz = haystack.size(), sz2 = needle.size();
        for(int i=0; i<sz; i++){
            if(haystack[i] == needle[0] && i+sz2 <= sz && haystack.substr(i, sz2) == needle) return i;
        }
        return -1;
    }
};