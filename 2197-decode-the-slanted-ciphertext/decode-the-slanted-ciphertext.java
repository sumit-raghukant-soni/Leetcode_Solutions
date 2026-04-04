class Solution {
    public String decodeCiphertext(String et, int rows) {
        int sz = et.length(), cols = sz/rows;
        char ch;
        StringBuilder ans = new StringBuilder(""), tmp = new StringBuilder("");

        for(int i=0; i<cols; i++){
            int j=i, row = 0, cnt = 0;
            tmp.setLength(0);
            while(((row * cols) + j) < sz){
                ch = et.charAt( (row * cols) + j);
                ans.append(ch);
                row++; j++;
            }
        }

        int sz2 = ans.length();
        while(sz2 > 0 && ans.charAt(sz2-1) == ' '){
            ans.deleteCharAt(sz2-1);
            sz2--;
        }

        return ans.toString();
    }
}