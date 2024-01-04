class Solution {
public:
    string predictPartyVictory(string senate) {
        int r=0, d=0;
        int sz = senate.size();

        for(int i=0; i<sz; i++){
            if(senate[i] == 'R'){
                if(d == 0) r++;
                else{
                    d--; sz++;
                    senate += 'D';
                }
            }
            else{
                if(r == 0) d++;
                else{
                    r--; sz++;
                    senate += 'R';
                }
            }
        }

        return r > d ? "Radiant" : "Dire";
    }
};