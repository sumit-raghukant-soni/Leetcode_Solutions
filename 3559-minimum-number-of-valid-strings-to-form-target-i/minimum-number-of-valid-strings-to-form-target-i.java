class Trie{
    boolean isEnd;
    Trie next[] = new Trie[26];
}

class Solution {
    public int dp[] = null;
    public int minValidStrings(String[] words, String target) {
        int sz1 = words.length, sz2 = target.length();
        
        dp = new int[sz2];
        Trie trie = new Trie();

        for(int i=0; i<sz1; i++){
            trie = insert(trie, words[i]);
        }

        solve(0, sz2, target, trie);

        return dp[0] == 1000000000 ? -1 : dp[0];
    }

    public int solve(int ind, int sz, String target, Trie trie){
        if(ind == sz) return 0;
        if(dp[ind] != 0) return dp[ind];

        Trie curr = trie;
        int val = 1000000000;
        for(int i=ind; i<sz; i++){
            int idx = target.charAt(i) - 'a';
            if(curr.next[idx] == null) break;
            curr = curr.next[idx];
            val = Math.min(val, 1 + solve(i+1, sz, target, trie));
        }

        return dp[ind] = val;
    }

    public Trie insert(Trie trie, String word){
        int sz = word.length();
        Trie curr = trie;

        for(int i=0; i<sz; i++){
            if(curr.next[word.charAt(i) - 'a'] == null){
                curr.next[word.charAt(i) - 'a'] = new Trie();
            }
            curr = curr.next[word.charAt(i) - 'a'];
        }

        curr.isEnd = true;

        return trie;
    }
}