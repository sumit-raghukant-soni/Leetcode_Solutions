class Solution {
public:
    bool isSumEqual(string firstWord, string secondWord, string targetWord) {
        int a=0, b=0, c=0;

        for(auto i : firstWord)
            a = (a*10) + (i-'a');
        
        for(auto i : secondWord)
            b = (b*10) + (i-'a');
        
        for(auto i : targetWord)
            c = (c*10) + (i-'a');
        
        return a+b == c;
    }
};