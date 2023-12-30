class Solution {
public:
    bool makeEqual(vector<string>& words) {
        int alpha[26] = {0};
        int sz = words.size();

        for(auto i : words)
            for(char j : i) alpha[j - 'a']++;

        for(auto i : alpha) if(i%sz != 0) return false;

        return true;
    }
};