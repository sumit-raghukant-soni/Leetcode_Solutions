class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int map[] = new int[27], sz = words.length;
        String[] words2 = new String[sz];

        for(int i=0; i<26; i++){
            map[order.charAt(i) - 'a'+1] = i+1;
        }

        for(int i=0; i<sz; i++){
            words2[i] = new String(words[i]);
        }

        Arrays.sort(words2, (a, b) -> {
                int sz2 = Math.min(a.length(), b.length());

                for(int i=0; i<sz2; i++){
                    if(map[a.charAt(i) - 'a' + 1] != map[b.charAt(i) - 'a' + 1]){
                        return map[a.charAt(i) - 'a' + 1] - map[b.charAt(i) - 'a' + 1];
                    }
                }

                return a.length() - b.length();
            });

        for(int i=0; i<sz; i++){
            if(!words2[i].equals(words[i])) return false;
        }

        return true;
    }
}