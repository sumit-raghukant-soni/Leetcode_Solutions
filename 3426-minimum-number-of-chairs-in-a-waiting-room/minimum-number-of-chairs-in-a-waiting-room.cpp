class Solution {
public:
    int minimumChairs(string s) {
        int chairs = 0, maxChairs = 0;

        for(char ch : s){
            if(ch == 'E') chairs++;
            else if(ch == 'L') chairs--;
            maxChairs = max(maxChairs, chairs);
        }   

        return maxChairs;
    }
};