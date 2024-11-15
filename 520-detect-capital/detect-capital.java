class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0, sz=word.length();

        for(int i=0; i<sz; i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') cnt++;
        }

        return (cnt == 0) || (cnt == sz) || (cnt == 1 && (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'));
    }
}