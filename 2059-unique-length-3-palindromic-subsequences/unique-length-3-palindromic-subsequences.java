class Solution {
    public int countPalindromicSubsequence(String s) {
        int sz = s.length(), cnt = 0;
        int map[][] = new int[26][26]; 
        int pre[] = new int[26], next[] = new int[26];
        
        for(int i=1; i<sz; i++){
            next[s.charAt(i) - 'a']++;
        }

        pre[s.charAt(0) - 'a']++;
        for(int i=1; i<sz-1; i++){
            char curr = s.charAt(i);
            // System.out.print(curr);
            next[curr - 'a']--;
            for(int j=0; j<26; j++){
                if(pre[j] == 0 || next[j] == 0 || map[curr-'a'][j] > 0) continue;
                // System.out.println(curr + " " + (char) (j + 'a'));
                map[curr-'a'][j]++;
                cnt++;
            }
            pre[curr - 'a']++;
            // i++;
            // while(i < sz && s.charAt(i) == curr){
            //     curr = s.charAt(i);
            //     next[curr - 'a']--;
            //     pre[curr - 'a']++;
            //     i++;
            // }
            // i--;
            // for(int j=0; j<26; j++) System.out.print((char) (j+'a') + " ");
            // System.out.println();
            // for(int j=0; j<26; j++) System.out.print(pre[j]);
            // System.out.println();
            // for(int j=0; j<26; j++) System.out.print(next[j]);
            // System.out.println();
        }

        // for(int j=0; j<26; j++){
        //     for(int i=0; i<26; i++){
        //         System.out.print(map[j][i] + ",");
        //     }
        //     System.out.println();
        // }

        return cnt;
    }
}