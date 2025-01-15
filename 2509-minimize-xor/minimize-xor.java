class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt1 = 0, cnt2 = 0, ans = 0, k, tmp = num2;

        while(tmp > 0){
            if((tmp&1) == 1) cnt1++;
            tmp = tmp >> 1;
        }

        k=30;
        while(cnt2 < cnt1 && k >= 0){
            int val = (int) Math.pow(2, k--);
            if((num1&val) >= 1){
                ans += val;
                cnt2++;
            }
        }

        k=0;
        while(cnt2 < cnt1){
            int val = (int) Math.pow(2, k++);
            if((ans&val) == 0){
                ans += val;
                cnt2++;
            }
        }

        return ans;
    }
}