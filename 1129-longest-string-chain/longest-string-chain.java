class Solution {
    public int longestStrChain(String[] words) {
        int sz = words.length, ans = -1;
        int fq[] = new int[sz];
        Arrays.sort(words, (a, b) -> a.length() - b.length() );

        for(int i=0; i<sz; i++){
            int sz2 = words[i].length();
            for(int j=i+1; j<sz; j++){
                int cnt = 0, ind = 0, sz3 = words[j].length();    
                if(sz3 > sz2+1) break;
                for(int k=0; k<sz3 && ind < sz2; k++){
                    if(words[j].charAt(k) == words[i].charAt(ind)){
                        ind++; cnt++;
                    }
                }
                // System.out.println(words[i] + " " + words[j] + ":" + cnt);
                if(cnt == sz2 && sz3-1 == sz2){
                    fq[j] = fq[j] > (1+fq[i]) ? fq[j] : (1+fq[i]);
                }
            }
        }

        for(int i=0; i<sz; i++){
            ans = ans > fq[i] ? ans : fq[i];
        }

        return ans+1;
    }
}