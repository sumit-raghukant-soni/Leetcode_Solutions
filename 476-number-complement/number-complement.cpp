class Solution {
public:
    int findComplement(int num) {
        int ans = 0, tmp = num, rem, k=0;

        while(tmp){
            rem = tmp&1;
            ans += (!rem) << k;
            k++;
            tmp = tmp >> 1;
        }

        return ans;
    }
};