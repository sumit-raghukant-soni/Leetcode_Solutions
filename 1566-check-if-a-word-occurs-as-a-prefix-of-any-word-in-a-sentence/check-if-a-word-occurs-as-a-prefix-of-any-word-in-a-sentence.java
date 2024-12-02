class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int sz = sentence.length(), sz2 = searchWord.length(), cnt = 1;
        boolean flg;

        for(int i=0; i<sz; i++){
            int j=0;
            flg = true;
            while(i < sz && sentence.charAt(i) != ' '){
                if(j < sz2 && searchWord.charAt(j) != sentence.charAt(i)) flg = false;
                i++; 
                if(j < sz2) j++;
            }
            if(j == sz2 && flg) return cnt;
            cnt++;
        }

        return -1;
    }
}