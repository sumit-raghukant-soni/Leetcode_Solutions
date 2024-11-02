class Solution {
    public boolean isCircularSentence(String sentence) {
        int sz = sentence.length();
        char last = '/';

        for(int i=0; i<sz; i++){
            if(i-1 >= 0 && sentence.charAt(i-1) == ' '){
                if(sentence.charAt(i) != last) return false;
            }
            if(sentence.charAt(i) != ' '){
                last = sentence.charAt(i);
            }
        }

        return last == sentence.charAt(0);
    }
}