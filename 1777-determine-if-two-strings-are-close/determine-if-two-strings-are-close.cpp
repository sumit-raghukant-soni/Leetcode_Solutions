class Solution {
public:
    bool closeStrings(string word1, string word2) {
        int sz1 = word1.length(), sz2 = word2.length();
        map<char, int> mp1, mp2;
        for(int i=0; i<sz1; i++)
            mp1[word1[i]]++;    

        for(int j=0; j<sz2; j++)
            mp2[word2[j]]++;

        if(mp1.size() != mp2.size()) return false;
        for(auto i : mp1)
            if(mp2.find(i.first) == mp2.end()) return false;

        map<int, int> mp3, mp4;
        for(auto i : mp1) mp3[i.second]++;
        for(auto i : mp2) mp4[i.second]++;

        return mp3 == mp4;
    }
};