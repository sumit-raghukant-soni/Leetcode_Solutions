class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[] odd1 = new int[26], odd2 = new int[26], even1 = new int[26], even2 = new int[26];

        for(int i=0; i<n; i++){
            if((i&1) == 0) even1[s1.charAt(i) - 'a']++;
            else odd1[s1.charAt(i) - 'a']++;

            if((i&1) == 0) even2[s2.charAt(i) - 'a']++;
            else odd2[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(even1[i] != even2[i]) return false;
            if(odd1[i] != odd2[i]) return false;
        }


        return true;
    }
}