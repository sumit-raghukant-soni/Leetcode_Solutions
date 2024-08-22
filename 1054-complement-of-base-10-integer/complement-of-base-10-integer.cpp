class Solution {
public:
    int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int ans = 0, tmp = n, rem, k=0;

        while(tmp){
            rem = tmp&1;
            ans += (!rem) << k;
            tmp = tmp >> 1;
            k++;
        }

        return ans;
    }
};