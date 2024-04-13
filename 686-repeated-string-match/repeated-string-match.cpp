class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        if(a.find(b) != string::npos) return 1;
        int sz1 = a.length(), sz2 = b.length();
        int i=1;
        string tmp = a;
        for(; a.length() <= sz2; i++){
            a += tmp;
            // cout << a << endl;
            if(a.length() >= sz2 && a.find(b) != string::npos) return i+1;
        }

        a+=tmp;
        if(a.find(b) != string::npos) return i+1;
        return -1;
    }
};