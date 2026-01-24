class Solution {
    public String reorganizeString(String s) {
        int sz = s.length();
        int freq[] = new int[26];
        String ans = "";

        for(char ch : s.toCharArray()) freq[ch - 'a']++;

        List<Character> lst = new ArrayList<>();

        while(lst.size() < sz){
            for(int i=0; i<26; i++){
                if(freq[i] == 0) continue;
                char curr = (char) (i + 'a');
                if(lst.isEmpty() || (lst.get(lst.size() - 1) - 'a') != i){
                    lst.add(curr);
                    freq[i]--;
                }
                else{
                    int ind = getIndex(lst, curr);
                    if(ind == -1) return "";
                    lst.add(ind, curr);
                    freq[i]--;
                }
                // System.out.println(lst);
            }
        }

        for(int i=0; i<sz; i++){
            ans += lst.get(i);
        }

        return ans;
    }

    private int getIndex(List<Character> lst, char curr){
        int ind = -1;

        if(lst.get(0) != curr) return 0;

        for(int i=0; i<lst.size()-1; i++){
            if(lst.get(i) != curr && lst.get(i+1) != curr) return i+1;
        }

        return ind;
    }
}