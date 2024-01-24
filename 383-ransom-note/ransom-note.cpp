class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int sz = ransomNote.size();
        int a[26] = {0}, b[26] = {0};

        for(char ch : ransomNote) a[ch - 'a']++;
        for(char ch : magazine) b[ch - 'a']++;

        for(int i=0; i<26; i++) if(a[i] != 0 && a[i] > b[i]) return false;

        return true;
    }
};