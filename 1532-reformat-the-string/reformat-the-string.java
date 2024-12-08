class Solution {
    public String reformat(String s) {
        int sz = s.length(), letters = 0, digits = 0;
        int nums[] = new int[10], alpha[] = new int[26];
        String ans = "";

        for(int i=0; i<sz; i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                alpha[s.charAt(i) - 'a']++;
                letters++;
            }
            else{
                nums[s.charAt(i)-'0']++;
                digits++;
            }
        }

        if(Math.abs(digits-letters) > 1) return "";

        int j=0,k=0;
        for(int i=0; i<sz; i++){
            if(i%2 == 0){
                while(j < 26 && alpha[j] == 0) j++;
                if(j >= 26) continue;
                alpha[j]--;
                ans += (char) (j+'a');
            }
            else{
                while(k < 10 && nums[k] == 0) k++;
                if(k >= 10) continue;
                nums[k]--;
                ans += (char) (k+'0');
            }
        }

        while(k < 10 && nums[k] == 0) k++;
        if(k < 10 && nums[k] == 1) ans = (char) (k + '0') + ans;

        return ans;
    }
}