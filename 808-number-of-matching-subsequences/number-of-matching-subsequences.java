class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int sz = s.length(), sz2 = words.length, ans = 0;
        Map<String, Integer> mp = new HashMap<>();
        List<Integer>[] freq = new List[26];

        for(int i=0; i<26; i++) freq[i] = new ArrayList<>();

        for(int i=0; i<sz; i++){
            freq[s.charAt(i) - 'a'].add(i);
        }

        for(int i=0; i<sz2; i++){
            if(mp.containsKey(words[i])){
                ans += mp.get(words[i]);
                continue;
            }
            int sz3 = words[i].length(), cnt = 0;
            int last = -1, curr = last;
            for(int k=0; k<sz3; k++){
                char ch = words[i].charAt(k);
                for(int j : freq[ch - 'a']){
                    if(j > last){
                        curr = j;
                        cnt++;
                        break;
                    }
                }
                if(curr != last) last = curr;
                else break;
            }
            if(cnt == sz3){
                ans++;
                mp.put(words[i], 1);
            }
            else mp.put(words[i], 0);
        }

        return ans;
    }
}