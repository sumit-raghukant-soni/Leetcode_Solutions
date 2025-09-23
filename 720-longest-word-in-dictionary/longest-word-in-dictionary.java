class Solution {
    public String longestWord(String[] words) {
        int sz = words.length, maxi = 0;
        String ans = "";
        Map<String, Integer> mp = new HashMap<>();
        Arrays.sort(words);

        for(int i=0; i<sz; i++){
            int cnt = mp.getOrDefault(words[i].substring(0, words[i].length()-1), 0) + 1;
            mp.put(words[i], cnt);
            if(cnt == words[i].length() && cnt > maxi){
                ans = words[i];
                maxi = cnt;
            }
        }

        return ans;
    }
}