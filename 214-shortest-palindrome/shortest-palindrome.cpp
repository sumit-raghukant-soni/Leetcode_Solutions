class Solution {
public:
    string shortestPalindrome(string s) {
        int sz = s.length();
        string rev = s;
        reverse(rev.begin(), rev.end());
        string to_test = s + "#" + rev;
        int i=0, j=i+1;
        vector<int> lps(to_test.length(), 0);

        while(j < to_test.length()){
            // cout << i << ":" << j << endl;
            if(to_test[i] != to_test[j] && i != 0){
                i = lps[i-1];
            }   
            else if(to_test[i] != to_test[j]){
                j++;
            }
            else if(to_test[i] == to_test[j]){
                lps[j] = i+1;
                i++, j++;
            }
        }

        int maxLps = lps[sz*2];
        // cout << to_test << endl;
        // for(int i : lps){
        //     cout << i << " ";
        // }
        string front = s.substr(maxLps);

        reverse(front.begin(), front.end());

        // cout << endl << front<<":"<<s << endl;

        return front+s;
    }
};