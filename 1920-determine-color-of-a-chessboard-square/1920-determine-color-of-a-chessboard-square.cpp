class Solution {
public:
    bool squareIsWhite(string coordinates) {
        int c = coordinates[0] - 'a', r = coordinates[1] - '1';
        return r != c && ((r+c)&1 == 1);
    }
};