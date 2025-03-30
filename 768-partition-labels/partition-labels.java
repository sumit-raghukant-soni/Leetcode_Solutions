class Solution {
    public List<Integer> partitionLabels(String s) {
        int sz = s.length();
        int alpha[] = new int[26], vis[] = new int[26];
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<sz; i++){
            alpha[s.charAt(i) - 'a']++;
        }

        int i=0, j, cnt, ch, total;
        while(i<sz){
            Arrays.fill(vis, -1);
            j = i; cnt = 0; total = 0;
            while(j<sz && (total > 0 || j == i)){
                // System.out.println("Start " + total + " " + j);
                ch = s.charAt(j) - 'a';
                alpha[ch]--;
                if(vis[ch] == -1){
                    total += alpha[ch];
                    vis[ch] = 1;
                }
                else total--;
                cnt++; j++;
            }
            // System.out.println(ans + " " + j);
            ans.add(cnt);
            i = j;
        }

        return ans;
    }
}