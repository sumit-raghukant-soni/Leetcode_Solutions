class Solution {
public:
    bool areSentencesSimilar(string s1, string s2) {
        if(s1.length() > s2.length()) return areSentencesSimilar(s2, s1);

        int sz1 = s1.length(), sz2 = s2.length();
        vector<string> words;
        vector<int> freq;
        string tmp = "";
        int s = 0, e;
        for(int i=0; i<=sz1; i++){
            if(s1[i] == ' ' || i == sz1){
                words.push_back(tmp);
                tmp = "";
            }
            else tmp += s1[i];
        }

        freq = vector<int>(words.size(), 0);
        e = words.size()-1;
        tmp = "";
        for(int i=0; i<=sz2; i++){
            if(s2[i] == ' ' || i == sz2){
                if(s <= e && tmp == words[s]) freq[s++]++;
                else break;
                tmp = "";
            }
            else tmp += s2[i];
        }

        tmp = "";
        for(int i=sz2-1; i>=0; i--){
            if(s2[i] == ' '){
                if(e >= s && tmp == words[e]) freq[e--]++;
                else break;
                tmp = "";
            }
            else tmp = s2[i] + tmp;
        }

        for(int i=0; i<words.size(); i++){
            if(freq[i] < 1) return false;
        }
        
        return true;
    }
};