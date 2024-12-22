class Solution {
    public int maxProduct(String[] words) {
        int sz = words.length, sz2, ans = 0;
        Set<Character> set;
        List<Set<Character>> sets = new ArrayList<>();

        for(int i=0; i<sz; i++){
            sz2 = words[i].length();
            set = new HashSet<Character>();
            for(int j=0; j<sz2; j++){
                set.add(words[i].charAt(j));
            }
            sets.add(set);
        }

        for(int i=0; i<sz; i++){
            for(int j=0; j<sz; j++){
                if(!check(sets, i, j)){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }

    private boolean check(List<Set<Character>> sets, int i, int j){
        Set<Character> set1 = sets.get(i), set2 = sets.get(j);

        for(Character ch : set1){
            if(set2.contains(ch)) return true;
        }

        return false;
    }
}