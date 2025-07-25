class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int sz = s.length(), ans = 0, j = 0;
        int isSame[] = new int[sz], flg = -1, val = 0;

        for(int i=0; i<sz; i++){
            if(i-1 >= 0 && s.charAt(i) == s.charAt(i-1)) isSame[i] = isSame[i-1] + 1;
            // System.out.print(isSame[i] + ",");
        }

        for(int i=0; i<sz; i++){
            if(isSame[i] > 1){
                // System.out.println("Direct");
                flg = i-1;
                j = i-1;
            }    
            else if(isSame[i] == 1){
                // System.out.println("Pair" + flg + " " + j);
                if(flg != -1){
                    j = flg + 1;
                }
                flg = i-1;
                // System.out.println("Pair end" + flg + " " + j);
            }

            ans = ans > (i-j+1) ? ans : (i-j+1);
        }

        return ans;
    }
}