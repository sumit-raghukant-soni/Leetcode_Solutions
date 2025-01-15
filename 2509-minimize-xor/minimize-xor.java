class Solution {
    public int minimizeXor(int num1, int num2) {
        int bits1[] = new int[31], bits2[] = new int[31];
        int i=31, ans = 0, cnt1 = 0, cnt2 = 0;

        while(i > 0){
            int rem1 = num1&1, rem2 = num2&1;
            num1 = num1 >> 1;
            num2 = num2 >> 1;
            i--;
            bits1[i] = rem1;
            // bits2[i] = rem2;
            cnt1 += rem1;
            cnt2 += rem2;
        }

        // i=30;
        // for(; i>=0; i--){
        //     System.out.print(bits1[i]);
        // }
        // System.out.println();
        // i=30;
        // for(; i>=0; i--){
        //     System.out.print(bits2[i]);
        // }
        // System.out.println();

        i = 0;
        for(; i<31 && cnt2 > 0; i++){
            if(bits1[i] == 1){
                // System.out.println("Here " + i + " " + Math.pow(2, 30-i));
                bits2[i] = 1; cnt2--; cnt1--;
                ans += Math.pow(2, 30-i);
            }
        }

        // System.out.println(ans + " " + cnt2);

        i = 30;
        for(; i>=0 && cnt2 > 0; i--){
            // System.out.println(bits2[i]);
            if(bits2[i] != 1 && cnt2 > 0){
                bits2[i] = 1; cnt2--;
                ans += Math.pow(2, 30-i);
            }
            // System.out.println(ans + " " + cnt2);
        }

        return ans;
    }
}