class Solution {
    public boolean canConstruct(String s, int k2) {
        int sz = s.length();
        if(sz == k2) return true;
        if(sz < k2) return false;
        int alpha[] = new int[26];

        for(int i=0; i<sz; i++){
            alpha[s.charAt(i) - 'a']++;
        }

        int cnt = 0;
        boolean flg = false;
        Arrays.sort(alpha);
        for(int i=25; i>=0; i--){
            // System.out.println(((char) (i+'a')) + " " + alpha[i]);
            if(alpha[i] == 0) continue;
            if(alpha[i]%2 == 1 && flg){
                // System.out.println("Odd" + " " + ((char) (i+'a')));
                cnt += alpha[i] - 1;
            }
            else if(alpha[i] == 1 && flg == false) {
                flg = true;
                cnt++;
            }
            else{
                if(alpha[i]%2 == 1) flg = true; 
                // System.out.println("Even" + " " + ((char) (i+'a')));
                cnt += alpha[i];
            }
        }

        // System.out.println((sz-cnt) + " " + (k2-1));   
        return (sz-cnt) <= k2-1;
    }
}