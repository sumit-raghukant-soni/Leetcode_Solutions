class Solution {
    public String largestGoodInteger(String num) {
        int sz = num.length();
        String ans = "";
        StringBuilder str = new StringBuilder("");

        for(int i=0; i<sz; i++){
            str.append(num.charAt(i));
            if(i >= 2){
                if(str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)){
                    ans = ans.compareTo(str.toString()) >= 0 ? ans : str.toString();
                }
                str.deleteCharAt(0);
            }
        }

        return ans.toString();
    }
}