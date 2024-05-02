class Solution {
public:
    int differenceOfSums(int n, int m) {
        int nd = 0, d = 0;

        for(int i=1; i<=n; i++){
            if(i%m) nd += i;
            else d += i;
        }

        return nd - d;
    }
};