class Solution {
    public String originalDigits(String s) {
        int sz = s.length();
        int alpha[] = new int[26], nums[] = new int[10];
        String ans = "";

        for(int i=0; i<sz; i++) alpha[s.charAt(i) - 'a']++;

        nums[0] = alpha['z'-'a'];
        nums[2] = alpha['w'-'a'];
        nums[4] = alpha['u'-'a'];
        nums[6] = alpha['x'-'a'];
        nums[8] = alpha['g'-'a'];

        nums[3] = alpha['t'-'a'] - nums[8] -  nums[2];
        nums[5] = alpha['f'-'a'] - nums[4];
        nums[7] = alpha['s'-'a'] - nums[6];

        nums[1] = alpha['o'-'a'] - nums[0] - nums[2] - nums[4];
        nums[9] = alpha['i'-'a'] - nums[6] - nums[8] - nums[5];

        for(int i=0; i<10; i++){
            for(int j=0; j<nums[i]; j++) ans += (char) (i + '0');
        }

        return ans;
    }
}