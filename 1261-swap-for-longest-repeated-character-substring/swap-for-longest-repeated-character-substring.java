class Solution {
    public int maxRepOpt1(String text) {
        int sz = text.length(), j, ans = 0, cnt, miss;
        int preCnt = 0, preI = -1, currCnt = 0, currI;
        int f[] = new int[26];

        for(char ch = 'a'; ch <= 'z'; ch++){
            Arrays.fill(f, 0);
            for(int i=0; i<sz; i++){
                f[text.charAt(i) - 'a']++;
            }
            for(int i=0; i<sz; i++){
                currI = i; currCnt = 0;
                while(i < sz && text.charAt(i) == ch){
                    i++;
                    currCnt++;
                }
                // System.out.println(preI + ":" + preCnt + " " + currI + ":" + currCnt);
                if(preI != -1 && preI == currI-1){
                    // System.out.println("Here" + (preCnt + currCnt + 1));
                    if(f[ch - 'a'] > (preCnt + currCnt)) ans = ans > (preCnt + currCnt + 1) ? ans : (preCnt + currCnt + 1);
                    else ans = ans > (preCnt + currCnt) ? ans : (preCnt + currCnt);
                }
                else {
                    ans = ans > currCnt ? ans : currCnt;
                }
                preI = i;
                preCnt = currCnt;
                // if(currI != i) i--;
            }
        }

        return ans;
    }
}