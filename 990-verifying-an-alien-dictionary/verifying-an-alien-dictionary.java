class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int map[] = new int[27], sz = words.length;
        String[] words2 = new String[sz];

        for(int i=0; i<26; i++){
            map[order.charAt(i) - 'a'+1] = i+1;
        }

        for(int i=0; i<sz; i++){
            String word = new String(words[i]);
            while(word.length() < 20) word += (char) ('a'-1);
            words2[i] = word;
        }

        for(int i=19; i>=0; i--){
            final int j = i;
            Arrays.sort(words2, (a, b) -> {
                return map[(a.charAt(j) - 'a')+1] - map[(b.charAt(j) - 'a')+1];
            });
        }

        for(int i=0; i<sz; i++){
            // System.out.println(words[i] + ":" + words2[i].substring(0, words[i].length()) + ",");
            if(!words2[i].substring(0, words[i].length()).equals(words[i])) return false;
        }

        return true;
    }
}